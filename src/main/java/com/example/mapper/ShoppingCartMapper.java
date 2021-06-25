package com.example.mapper;

import com.example.bean.Address;
import com.example.bean.Shop;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingCartMapper
{
    void insertGoods(Integer gId, String wxId);

    void deleteGoods(Integer gId, String wxId);

    List<Shop> selectGoods(String wxId);

    List<Shop> selectWaitPaid(String wxId);

    List<Shop> selectWaitSend(String wxId);

    List<Shop> selectWaitMess(String wxId);

    void updatePaid(Integer gId, String wxId);

    void updateSend(Integer gId, String wxId);

    void updateMess(Integer gId, String wxId);

    void insertPaid(Integer gId, String wxId);

    void insertAddress(Address address);

    void updateAddress(Address address);

    Address selectAddress(String wxId);
}
