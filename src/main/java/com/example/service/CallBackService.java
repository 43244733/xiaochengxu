package com.example.service;


import com.example.bean.CallBack;

public interface CallBackService
{
    /**
     * 回调通知
     * @param callBack
     * @return
     */
    int insertCallBack(CallBack callBack);

    /**
     * 验证回调时订单信息的算法签名
     * @param id
     * @return
     */
    String selectSignByTrade(Long id);
}

