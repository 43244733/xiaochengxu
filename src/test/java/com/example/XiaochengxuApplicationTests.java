package com.example;

import com.example.util.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class SpringbootRedisApplicationTests {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private RedisUtil redisUtil;

    @Test
    void contextLoads() {
//        System.out.println(redisUtil.get("myKey"));
//        redisTemplate.opsForValue().set("myKey","myValue");
//        System.out.println(redisTemplate.opsForValue().get("myKey1"));
//        System.out.println(redisUtil.get("myKey1"));
//        System.out.println(redisUtil.get("myKey"));
        System.out.println(redisUtil.set("nihao", "nihuai"));
        System.out.println(redisUtil.get("nihao"));
    }
}
