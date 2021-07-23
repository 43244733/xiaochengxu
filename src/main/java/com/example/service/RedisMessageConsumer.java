//package com.example.service;
//
//import com.example.bean.User;
//import com.example.util.RedisUtil;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import java.util.concurrent.Executors;
//import java.util.concurrent.ScheduledExecutorService;
//import java.util.concurrent.TimeUnit;
//
//public class RedisMessageConsumer {
//
//    private static final Logger log = LoggerFactory.getLogger(RedisMessageConsumer.class);
//
//    /**
//     * 参数是初始化线程池子的大小
//     */
//    private static final ScheduledExecutorService batchTaskPool = Executors.newScheduledThreadPool(2);
//
//    @Autowired
//    private RedisUtil redisUtil;
//
//    /**
//     * 消费消息
//     *
//     * @param acceptUser 接收消息的用户
//     */
//    public void consumerMessage(final User acceptUser) {
//
//        //新建一个线程，线程池获取消息
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                while (true) {
//                    // 0是timeout, 返回的是一个集合，第一个是消息的key，第二个是消息的内容
//                    String message = redisUtil.lBRightPop(acceptUser.getName() + ":msg", 5, TimeUnit.SECONDS);
//
//                    String sendUserName = message.substring(0, message.indexOf("*-*"));//获取消息的发送者
//                    message = message.substring(message.indexOf("*-*") + 3);//获取消息内容
//
//                    System.out.println(acceptUser.getName() + " -> 收到 -> " + sendUserName + ":" + message);
//
////                    log.info("ThreadName is {},user {} consumer message {} ,sended by {}", Thread.currentThread().getName(), acceptUser.getUsername(), message, sendUserName);
//                }
//            }
//        };
//
//        //线程池中获取消息
//        //第一个参数是需要执行的任务，第二个参数是第一次的延迟时间，第三个参数是两次执行的时间间隔，第四个参数是时间的单位
//        batchTaskPool.scheduleWithFixedDelay(runnable, 3, 5, TimeUnit.SECONDS);
//    }
//
//}
