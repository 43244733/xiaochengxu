package com.example.listener;

import com.example.service.OrderInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Component;

@Component
public class OrderExpirationListener extends KeyExpirationEventMessageListener {

    @Autowired
    private OrderInfoService orderInfoService;

    // 日志记录
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderExpirationListener.class);

    public OrderExpirationListener(RedisMessageListenerContainer listenerContainer) {
        super(listenerContainer);
    }

    @Override
    public void onMessage(Message message, byte[] pattern) {
        // 获取返回过期的订单号
        Long expiredOrderId = Long.valueOf(message.toString());
        int i = orderInfoService.updateOverTimeStatus(expiredOrderId);
        if (i > 0) {
            LOGGER.info("订单号：" + expiredOrderId + "已过期, 修改成功");
        } else {
            LOGGER.info("订单号：" + expiredOrderId + "已过期, 修改失败");
        }
    }
}
