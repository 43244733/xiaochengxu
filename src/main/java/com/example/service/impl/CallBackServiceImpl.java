package com.example.service.impl;


import com.example.bean.CallBack;
import com.example.mapper.CallBackMapper;
import com.example.service.CallBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CallBackServiceImpl implements CallBackService {

    @Autowired
    private CallBackMapper callBackMapper;

    @Override
    public int insertCallBack(CallBack callBack) {
        return callBackMapper.insertCallBack(callBack);
    }

    @Override
    public String selectSignByTrade(Long id) {
        return callBackMapper.selectSignByTrade(id);
    }
}

