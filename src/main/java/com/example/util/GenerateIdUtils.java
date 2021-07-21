package com.example.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Service
public class GenerateIdUtils {

    private static Logger logger = LoggerFactory.getLogger(GenerateIdUtils.class);

    public static final String REDIS_KEY_PREFIX = "userId:orderId:";

    @Autowired
    public RedisUtil redisUtil;

    /**
     * 获取有过期时间的自增长ID
     * @param key
     * @return
     */
    public long generate(String key) {
        String redisKey = REDIS_KEY_PREFIX + key;
        String value = StringUtils.isBlank(redisUtil.getStr(redisKey)) ? "0" : redisUtil.get(redisKey).toString();
        long valueNum = Long.parseLong(value);
        valueNum++;
        value = String.valueOf(valueNum);
        redisUtil.set(redisKey, value);
        redisUtil.expire(redisKey, 2);//2秒过期
        return valueNum;
    }

    public String generateId() {
        // 生成id为当前日期（yyyyMMddHHmmss）+6位（从000000开始不足位数补0）
        LocalDateTime now = LocalDateTime.now();
        String idPrefix = getIdPrefix(now);// 生成yyyyMMddHHmmss
        String id = idPrefix + String.format("%1$05d", generate(idPrefix));

        System.out.println("id---------" + id);
        return id;
    }

    public static String getIdPrefix(LocalDateTime now) {
        return now.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
    }

    public Date getExpireAtTime(LocalDateTime now) {
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = now.plusSeconds(20);
        ZonedDateTime zdt = localDateTime.atZone(zoneId);
        Date date = Date.from(zdt.toInstant());
        return date;
    }

    public String getGenerateId() {
        return this.generateId();
    }

    public static void main(String[] args) {
        GenerateIdUtils generateIdUtils = new GenerateIdUtils();
        System.out.println(generateIdUtils.getGenerateId());
    }
}