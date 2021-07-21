package com.example.mapper;

import com.example.bean.CallBack;
import com.example.bean.Message;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CallBackMapper
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
