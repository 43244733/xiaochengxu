package com.example.service.impl;

import com.example.bean.Address;
import com.example.bean.Shop;
import com.example.mapper.ShoppingCartMapper;
import com.example.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService
{
    @Autowired
    private ShoppingCartMapper shoppingCartMapper;

    @Override
    public void insertGoods(Integer gId, String wxId)
    {
        shoppingCartMapper.insertGoods(gId, wxId);
    }

    @Override
    public void deleteGoods(Integer gId, String wxId)
    {
        shoppingCartMapper.deleteGoods(gId, wxId);
    }

    @Override
    public List<Shop> selectGoods(String wxId)
    {
        return shoppingCartMapper.selectGoods(wxId);
    }

    @Override
    public List<Shop> selectWaitPaid(String wxId)
    {
        return shoppingCartMapper.selectWaitPaid(wxId);
    }

    @Override
    public List<Shop> selectWaitSend(String wxId)
    {
        return shoppingCartMapper.selectWaitSend(wxId);
    }

    @Override
    public List<Shop> selectWaitMess(String wxId)
    {
        return shoppingCartMapper.selectWaitMess(wxId);
    }

    @Override
    public void updatePaid(Integer gId, String wxId)
    {
        shoppingCartMapper.updatePaid(gId, wxId);
    }

    @Override
    public void updateSend(Integer gId, String wxId)
    {
        shoppingCartMapper.updateSend(gId, wxId);
    }

    @Override
    public void updateMess(Integer gId, String wxId)
    {
        shoppingCartMapper.updateMess(gId, wxId);
    }

    @Override
    public void insertPaid(Integer gId, String wxId)
    {
        shoppingCartMapper.insertPaid(gId, wxId);
    }

    @Override
    public void insertAddress(Address address)
    {
        shoppingCartMapper.insertAddress(address);
    }

    @Override
    public void updateAddress(Address address)
    {
        shoppingCartMapper.updateAddress(address);
    }

    @Override
    public Address selectAddress(String wxId)
    {
        return shoppingCartMapper.selectAddress(wxId);
    }
}
