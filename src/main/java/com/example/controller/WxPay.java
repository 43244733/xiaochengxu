package com.example.controller;

import com.example.bean.WxPayer;
import com.example.util.Sign_java;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.TreeMap;

@RestController
@SpringBootApplication
public class WxPay {
    ShoppingCartController shoppingCartController = new ShoppingCartController();
    private static final Logger LOGGER = LoggerFactory.getLogger(WxPay.class);

    @RequestMapping(value = "/success", method = RequestMethod.POST)
    @ResponseBody
    public String success(String wxPayer) {
        System.out.println(wxPayer);
        return "success";
    }

    @RequestMapping(value = "/buyGoods", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public Map buyGoods(Integer prices) {
        // 返回价格单位为 '分'
        Integer pay = prices * 100;
        // 用法示例
        Map<String, String> order = new TreeMap<String, String>();
        order.put("amount", String.valueOf(pay));
        order.put("app_id", "2104129103");
        order.put("description", "XiaoLianXiangYing");
        // 回调
        order.put("notify_url", "http://www.hututu777.cn/success");
        order.put("out_trade_no", "122");
        order.put("pay_type", "wechat");
        // 通信密钥
        String key = "7f36f8af1b6e19bd75c63584d8ca244b";
        sign s = new sign();
        String sign = s.sign(order, key);
        order.put("sign", sign);
        System.out.println(order);
        return order;
    }
}

class sign {
    String sign(Map<String, String> map, String key) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
        }
        sb.append("key=").append(key);
        return DigestUtils.md5DigestAsHex(sb.toString().getBytes()).toUpperCase();
    }
}
