package com.example.dao;


import com.example.bean.OrderInfo;
import com.example.controller.WxPayController;
import com.example.service.OrderInfoService;
import com.example.util.DateUtil;
import com.example.util.SequenceUtil;
import com.example.util.Sign;
import com.example.util.WxConstUtil;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Repository;
import org.springframework.util.DigestUtils;

import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

@ConfigurationProperties("wx.config")
@Repository
public class WxPayDao {

    @Autowired
    private OrderInfoService orderInfoService;

    private String appId;

    private String key;

    private static final Logger LOGGER = LoggerFactory.getLogger(WxPayDao.class);

    public Map<String, String> wxPay(String recName, String recAddress, String recPhone, Integer goodsId,
                                     Integer userId, String userName, Integer goodsCount, BigDecimal prices,
                                     String goodsName) throws UnknownHostException {

        /*------------------------------------------生成订单------------------------------------------*/
        OrderInfo orderInfo = new OrderInfo();
        // 订单号
        Long orderId = SequenceUtil.getInstance().nextId();
        orderInfo.setId(orderId);
        // 订单状态 0->未支付 1->已支付 2->超时 3->已发货 4->已收货 5->待退款 6->已退款
        orderInfo.setStatus(0);
        // 收货人姓名
        orderInfo.setRecName(recName);
        // 收货地址
        orderInfo.setRecAddress(recAddress);
        // 收货人联系方式
        orderInfo.setRecPhone(recPhone);
        // 商品ID
        orderInfo.setGoodsId(goodsId);
        // 商品名称
        orderInfo.setGoodsName(goodsName);
        // 商家ID
        orderInfo.setUserId(userId);
        // 商家名
        orderInfo.setUserName(userName);
        // 商品数量
        orderInfo.setGoodsCount(goodsCount);
        // 商品价格
        BigDecimal pricesResult = new BigDecimal(String.valueOf(prices));
        pricesResult.divide(new BigDecimal(100));
        orderInfo.setGoodsPrice(pricesResult);
        // 订单创建时间
        orderInfo.setCreateDate(new Date());


        /*------------------------------------------微信支付------------------------------------------*/

        // TreeMap 有序
        Map<String, String> order = new TreeMap<String, String>();
        order.put("amount", String.valueOf(prices));
        order.put("app_id", WxConstUtil.APP_ID);
        order.put("description", goodsName);

        // 回调方法
        // 获取本机IPV4地址
        String IPV4 = InetAddress.getLocalHost().getHostAddress();
        String notify_url = "http://" + IPV4 + "/success";
        order.put("notify_url", notify_url);

        // 商家订单编号
        order.put("out_trade_no", String.valueOf(orderId));
        order.put("pay_type", "wechat");

        // 通信密钥
//        String key = "7f36f8af1b6e19bd75c63584d8ca244b";
        String sign = Sign.sign(order, WxConstUtil.KEY);

        // 创建订单
        orderInfoService.insertOrderInfo(orderInfo);

        order.put("sign", sign);

        LOGGER.info("订单详情：" + order);

        return order;
    }

}
