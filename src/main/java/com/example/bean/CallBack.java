package com.example.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 微信支付通知回调
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CallBack {

    private Integer id;

    private String tradeNo;

    private String inTradeNo;

    private String outTradeNo;

    private String tradeType;

    private String description;

    private String payType;

    private Integer amount;

    private String attach;

    private String createTime;

    private String payTime;

    private Integer notifyCount;






}
