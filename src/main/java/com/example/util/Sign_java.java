package com.example.util;

import org.springframework.util.DigestUtils;
import java.util.Map;
import java.util.TreeMap;

/*
    微信支付
 */
public class Sign_java {
    //签名算法
    static class sign {
        String sign(Map<String, String> map, String key) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
            sb.append("key=").append(key);
            return DigestUtils.md5DigestAsHex(sb.toString().getBytes()).toUpperCase();
        }
    }

    public static void main(String[] args) {
        // 用法示例
        Map<String, String> order = new TreeMap<String,String>();
        order.put("amount", "8900");
        order.put("app_id", "2104129103");
        order.put("description", "XiaoLianXiangYing");
        order.put("notify_url", "http://www.hututu777.cn/success");
        order.put("out_trade_no", "123");
        order.put("pay_type", "wechat");

        // 通信密钥
        String key = "7f36f8af1b6e19bd75c63584d8ca244b";
        sign s = new sign();
        String sign = s.sign(order,key);
        System.out.println(sign);
    }
}
