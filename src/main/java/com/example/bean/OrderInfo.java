package com.example.bean;

import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderInfo {

    private Long id;                // 订单号

    private Integer status;         // 订单状态 0->未支付 1->已支付 2->超时 3->已发货 4->已收货 5->待退款 6->已退款

    private String recName;         // 收货人

    private String recAddress;      // 收货地址

    private String recPhone;        // 收货人联系方式

    private Integer goodsId;        // 商品ID

    private String goodsName;       // 商品名

    private Integer userId;            // 商家id

    private String userName;        // 商家名

    private Integer goodsCount;     // 商品数量

    // 货币类计算要求精度较高，非常大量的，很小的精度误差也会积少成多变成大误差，所以需要用到BigDecimal
    private BigDecimal goodsPrice;  // 商品价格

    private Date createDate;        // 下单时间

    private Date payDate;           // 支付时间

    private Date deliverDate;       // 发货时间

    private Date recDate;           // 收货时间

}