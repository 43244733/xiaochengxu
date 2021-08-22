package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.example.bean.User;
import com.example.util.RedisUtil;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.*;

@RestController
public class CustomerServiceController {

    /**
     * 参数是初始化线程池子的大小 IO密集型
     */
    private static final ScheduledExecutorService batchTaskPool = Executors.newScheduledThreadPool(2);

  /*  private static final ExecutorService threadPool = new ThreadPoolExecutor(
            2,
            4,
            3,
            TimeUnit.SECONDS,
            new LinkedBlockingDeque<>(2),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.AbortPolicy() // 如果满了 还有线程要进来 不处理 直接抛出异常
    );
   */

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerServiceController.class);

    @Autowired
    private RedisUtil redisUtil;

    /**
     * 消费消息
     *
     * @param acceptUser 接收消息的用户
     */
    @ApiOperation("客服接收消息")
    @RequestMapping(value = "/consumerMessage", method = RequestMethod.GET)
    public void consumerMessage(User acceptUser) {

        //新建一个线程，线程池获取消息
        Runnable runnable = () -> {
            while (true) {
                // 0是timeout, 返回的是一个集合，第一个是消息的key，第二个是消息的内容
                String message = redisUtil.lBRightPop(acceptUser.getName() + ":msg", 5, TimeUnit.SECONDS);

                String sendUserName = message.substring(0, message.indexOf("*-*"));//获取消息的发送者
                message = message.substring(message.indexOf("*-*") + 3);//获取消息内容
                LOGGER.info("ThreadName is {},user {} consumer message {} ,sended by {}", Thread.currentThread().getName(), acceptUser.getName(), message, sendUserName);
            }
        };

        //线程池中获取消息
        //第一个参数是需要执行的任务，第二个参数是第一次的延迟时间，第三个参数是两次执行的时间间隔，第四个参数是时间的单位
        batchTaskPool.scheduleWithFixedDelay(runnable, 2, 3, TimeUnit.SECONDS);
    }

    /**
     * 发送消息的方法
     */
    @ApiOperation("顾客发送信息")
    @RequestMapping(value = "/sendMessage", method = RequestMethod.POST)
    public boolean sendMessage(User sendUser, User acceptUser, String... messages) {

        String key = acceptUser.getName() + ":msg";

        //将消息的内容加上消息的发送人以 *-* 分割，不能用增强for循环
        for (int i = 0, length_1 = messages.length; i < length_1; i++) {
            messages[i] = sendUser.getName() + "*-*" + messages[i];
        }

        // 传入消息队列
        Long lpushCount = redisUtil.lLeftPushAll(key, messages);  // 返回值是还有多少消息未消费

        LOGGER.info("user {} send message [{}] to {}", sendUser.getName(), messages, acceptUser.getName());
        LOGGER.info("user {} has {} messages ", acceptUser.getName(), lpushCount);

        return true;
    }
}
