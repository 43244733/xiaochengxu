package com.example.listener;

import com.example.bean.OrderInfo;
import com.example.service.OrderInfoService;
import com.example.service.ShopService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class OrderExpirationListener extends KeyExpirationEventMessageListener {

    @Autowired
    private OrderInfoService orderInfoService;

    @Autowired
    private ShopService shopService;

    // 日志记录
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderExpirationListener.class);

    public OrderExpirationListener(RedisMessageListenerContainer listenerContainer) {
        super(listenerContainer);
    }

    @Transactional
    @Override
    public void onMessage(Message message, byte[] pattern) {
        // 获取返回过期的订单号
        Long expiredOrderId = Long.valueOf(message.toString());
        int i = orderInfoService.updateOverTimeStatus(expiredOrderId);
        OrderInfo orderInfo = orderInfoService.selectOrderById(expiredOrderId);
        // 订单回退后 商品数量+1
        shopService.updateAddStock(orderInfo.getGoodsId());

        if (i > 0) {
            LOGGER.info("订单号：" + expiredOrderId + "已过期, 修改成功");
        } else {
            LOGGER.info("订单号：" + expiredOrderId + "已过期, 修改失败");
        }
    }
}
