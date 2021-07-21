package com.example.util;


import cn.hutool.core.date.SystemClock;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.net.NetworkInterface;

/**
 * 雪花算法生成全局唯一ID
 */
@Slf4j
public class SequenceUtil {

    /**
     * 初始时间截
     * 时间起始标记点，作为基准，一般取系统的最近时间（一旦确定不能变动）
     */
    private final static long twepoch = 1288834974657L;
    /**
     * 机器id所占的位数
     * 机器标识位数
     */
    private final static long workerIdBits = 5L;
    /**
     * 数据标识id所占的位数
     */
    private final static long datacenterIdBits = 5L;
    /**
     * 支持的最大机器id，结果是31 (这个移位算法可以很快的计算出几位二进制数所能表示的最大十进制数)
     */
    private final static long maxWorkerId = -1L ^ (-1L << workerIdBits);
    /**
     * 支持的最大数据标识id，结果是31
     */
    private final static long maxDatacenterId = -1L ^ (-1L << datacenterIdBits);
    /**
     * 毫秒内自增位
     * 序列在id中占的位数
     */
    private final static long sequenceBits = 12L;
    /**
     * 机器ID的偏移量(12)
     */
    private final static long workerIdShift = sequenceBits;
    /**
     * 数据中心ID的偏移量(12+5)
     */
    private final static long datacenterIdShift = sequenceBits + workerIdBits;
    /**
     * 时间戳左移动位 时间截的偏移量(5+5+12)
     */
    private final static long timestampLeftShift = sequenceBits + workerIdBits + datacenterIdBits;
    /**
     * 生成序列的掩码
     */
    private final static long sequenceMask = -1L ^ (-1L << sequenceBits);

    /**
     * 工作节点ID(0~31)
     */
    private long workerId;

    /**
     * 数据标识id部分
     */
    private long datacenterId;
    /**
     * 0，并发控制 毫秒内序列(0~4095)
     */
    private volatile long sequence = 0L;
    /**
     * 上次生产id时间戳
     */
    private static long lastTimestamp = -1L;


    private static class SingletonHandler {
        private static SequenceUtil sequence = new SequenceUtil();
    }

    public static SequenceUtil getInstance() {
        return SingletonHandler.sequence;
    }

    private SequenceUtil() {
        this.datacenterId = getDatacenterId(maxDatacenterId);
        this.workerId = getMaxWorkerId(datacenterId, maxWorkerId);
    }

    /**
     * @param workerId     工作机器ID
     * @param datacenterId 序列号
     */
//    public Sequence(long workerId, long datacenterId) {
//        if (workerId > maxWorkerId || workerId < 0) {
//            throw new IllegalArgumentException(String.format("worker Id can't be greater than %d or less than 0", maxWorkerId));
//        }
//        if (datacenterId > maxDatacenterId || datacenterId < 0) {
//            throw new IllegalArgumentException(
//                    String.format("datacenter Id can't be greater than %d or less than 0", maxDatacenterId));
//        }
//        this.workerId = workerId;
//        this.datacenterId = datacenterId;
//    }


    /**
     * 获取下一个ID
     */
    public synchronized Long nextId() {
        long timestamp = timeGen();
        //闰秒
        if (timestamp < lastTimestamp) {
            long offset = lastTimestamp - timestamp;
            if (offset <= 5) {
                try {
                    wait(offset << 1);
                    timestamp = timeGen();
                    if (timestamp < lastTimestamp) {
                        throw new RuntimeException(String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds", offset));
                    }
                }
                catch (Exception e) {
                    throw new RuntimeException(e);
                }
            } else {
                throw new RuntimeException(String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds", offset));
            }
        }

        if (lastTimestamp == timestamp) {
            // 相同毫秒内，序列号自增
            sequence = (sequence + 1) & sequenceMask;
            if (sequence == 0) {
                // 同一毫秒的序列数已经达到最大
                timestamp = tilNextMillis(lastTimestamp);
            }
        } else {
            // 不同毫秒内，序列号置为 1 - 3 随机数
            sequence = 0L;
        }

        lastTimestamp = timestamp;
        // 时间戳部分
        return ((timestamp - twepoch) << timestampLeftShift)
                // 数据中心部分
                | (datacenterId << datacenterIdShift)
                // 机器标识部分
                | (workerId << workerIdShift)
                // 序列号部分
                | sequence;
    }


    /**
     * id信息解析方法
     *
     * @param id
     * @return
     */
    public static Long[] decodeIdInfo(Long id) {
        Long[] idInfos = new Long[4];
        idInfos[0] = id & 0xFFF00000;
        idInfos[1] = (id << 42) >>> 59;
        idInfos[2] = (id << 47) >>> 59;
        idInfos[3] = (id << 52) >>> 52;
        return idInfos;
    }

    private long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    private long timeGen() {
        return SystemClock.now();
    }

    /**
     * 获取 maxWorkerId
     */
    private static long getMaxWorkerId(long datacenterId, long maxWorkerId) {
        StringBuilder mpid = new StringBuilder();
        mpid.append(datacenterId);
        String name = ManagementFactory.getRuntimeMXBean().getName();
        if (StringUtils.isNotEmpty(name)) {
            /*
             * GET jvmPid
             */
            mpid.append(name.split("@")[0]);
        }
        /*
         * MAC + PID 的 hashcode 获取16个低位
         */
        return (mpid.toString().hashCode() & 0xffff) % (maxWorkerId + 1);
    }

    /**
     * 数据标识id部分
     */
    private static long getDatacenterId(long maxDatacenterId) {
        long id = 0L;
        try {
            InetAddress ip = InetAddress.getLocalHost();
            NetworkInterface network = NetworkInterface.getByInetAddress(ip);
            if (network == null) {
                id = 1L;
            } else {
                byte[] mac = network.getHardwareAddress();
                if (null != mac) {
                    id = ((0x000000FF & (long) mac[mac.length - 1]) | (0x0000FF00 & (((long) mac[mac.length - 2]) << 8))) >> 6;
                    id = id % (maxDatacenterId + 1);
                }
            }
        }
        catch (Exception e) {
            log.warn(" getDatacenterId: " + e.getMessage());
        }
        return id;
    }

    public static void main(String[] args) throws InterruptedException {
      /*  Set list = new HashSet();
        Collection collection = Collections.synchronizedCollection(list);
        for (int i = 1; i <= 100000; i++) {
            new Thread( () -> {
                collection.add(SequenceUtil.getInstance().nextId());
            }).start();
        }

        Thread.sleep(2000);

        System.out.println(collection.size());*/

        long t = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            String s0 = String.valueOf(11);
        }
        System.out.println("耗时" + (System.currentTimeMillis() - t));

        t = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            String s = "" + 11;
        }
        System.out.println("耗时" + (System.currentTimeMillis() - t));

        String str = "";
        t = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            String s = str + 11;
        }
        System.out.println("耗时" + (System.currentTimeMillis() - t));

    }
}