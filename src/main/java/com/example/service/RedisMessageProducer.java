//package com.example.service;
//
//import com.example.bean.User;
//import com.example.util.RedisUtil;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//
//public class RedisMessageProducer {
//
//    private static final Logger log = LoggerFactory.getLogger(RedisMessageProducer.class);
//
//    @Autowired
//    private RedisUtil redisUtil;
//
//    /**
//     * 发送消息的方法
//     */
//    public boolean sendMessage(User sendUser, User acceptUser, String... messages) {
//
//        String key = acceptUser.getName() + ":msg";
//
//        //将消息的内容加上消息的发送人以 *-* 分割，不能用增强for循环
//        for (int i = 0, length_1 = messages.length; i < length_1; i++) {
//            messages[i] = sendUser.getName() + "*-*" + messages[i];
//        }
//
//        // 传入消息队列
//        Long lpushCount = redisUtil.lLeftPushAll(key, messages);  //返回值是还有多少消息未消费
//
//        System.out.println("lpushCount: " + lpushCount);
//        System.out.println(sendUser.getName() + " -> 发送 -> " + messages);
//
////        log.info("user {} send message [{}] to {}", sendUser.getName(), messages, acceptUser.getName());
////        log.info("user {} has {} messages ", acceptUser.getName(), lpushCount);
//
//        return true;
//    }
//
//}
