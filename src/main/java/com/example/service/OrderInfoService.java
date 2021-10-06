package com.example.service;


import com.example.bean.OrderInfo;
import com.google.common.collect.Ordering;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface OrderInfoService
{
    /**
     * 生成订单
     * @param orderInfo
     * @return
     */
    int insertOrderInfo(OrderInfo orderInfo);

    /**
     * 添加支付时间和支付状态
     * @param date
     * @return
     */
    int updatePayTime(@Param("date") Date date, @Param("id") Long id);

    /**
     * 根据订单号搜索订单
     * @param id
     * @return
     */
    OrderInfo selectOrderById(Long id);

    /**
     * 更新订单状态为超时
     * @param orderId
     * @return
     */
    int updateOverTimeStatus(Long orderId);
}

