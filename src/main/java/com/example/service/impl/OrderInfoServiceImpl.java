package com.example.service.impl;

import com.example.bean.OrderInfo;
import com.example.dao.FaceDao;
import com.example.mapper.OrderInfoMapper;
import com.example.service.OrderInfoService;
import com.google.common.collect.Ordering;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OrderInfoServiceImpl implements OrderInfoService {

    @Autowired
    private OrderInfoMapper orderInfoMapper;


    @Override
    public int insertOrderInfo(OrderInfo orderInfo) {
        return orderInfoMapper.insertOrderInfo(orderInfo);
    }

    @Override
    public int updatePayTime(Date date, Long id) {
        return orderInfoMapper.updatePayTime(date, id);
    }

    @Override
    public OrderInfo selectOrderById(Long id) {
        return orderInfoMapper.selectOrderById(id);
    }

    @Override
    public int updateOverTimeStatus(Long orderId) {
        return orderInfoMapper.updateOverTimeStatus(orderId);
    }
}
