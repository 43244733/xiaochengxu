package com.example.controller;

import com.example.bean.Address;
import com.example.bean.Shop;
import com.example.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@SpringBootApplication
public class ShoppingCartController
{
    @Autowired
    private ShoppingCartService shoppingCartService;

    // 查询购物车商品
    @RequestMapping(value = "/selectCart", produces = "application/json; charset=utf-8")
    public List<Shop> showMessage(String wxId)
    {
        return shoppingCartService.selectGoods(wxId);
    }

    // 添加至购物车
    @RequestMapping(value = "/insertCart")
    public String insertCart(Integer gId, String wxId)
    {
        shoppingCartService.insertGoods(gId, wxId);
        return "成功添加至购物车";
    }

    // 删除
    @RequestMapping(value = "/deleteCart")
    public String deleteCart(Integer gId, String wxId)
    {
        shoppingCartService.deleteGoods(gId, wxId);
        return "成功删除";
    }

    // 查询待付款
    @RequestMapping(value = "/selectWaitPaid", produces = "application/json; charset=utf-8")
    public List<Shop> selectWaitPaid(String wxId)
    {
        return shoppingCartService.selectWaitPaid(wxId);
    }

    // 查询已发货
    @RequestMapping(value = "/selectWaitSend", produces = "application/json; charset=utf-8")
    public List<Shop> selectWaitSend(String wxId)
    {
        return shoppingCartService.selectWaitSend(wxId);
    }

    // 查询待评论
    @RequestMapping(value = "/selectWaitMess", produces = "application/json; charset=utf-8")
    public List<Shop> selectWaitMess(String wxId)
    {
        return shoppingCartService.selectWaitMess(wxId);
    }

    // 修改
    @RequestMapping(value = "/updatePaid")
    public String updatePaid(Integer gId, String wxId)
    {
        shoppingCartService.updatePaid(gId, wxId);
        return "待付款";
    }

    @RequestMapping(value = "/updatePaidTwo")
    public String updatePaidTwo(Integer gId, String wxId)
    {
        shoppingCartService.insertPaid(gId, wxId);
        return "待付款";
    }

    @RequestMapping(value = "/updateSend")
    public String updateSend(Integer gId, String wxId)
    {
        shoppingCartService.updateSend(gId, wxId);
        return "已发货";
    }

    @RequestMapping(value = "/updateMess")
    public String updateMess(Integer gId, String wxId)
    {
        shoppingCartService.updateMess(gId, wxId);
        return "待评论";
    }

    // 查询地址
    @RequestMapping(value = "/selectAddress")
    public Address selectAddress(String wxId)
    {
        return shoppingCartService.selectAddress(wxId);
    }

    // 添加或修改地址
    @RequestMapping(value = "/updateAddress")
    public void updateAddress(Address address)
    {
        Address addressResult = shoppingCartService.selectAddress(address.getWxId());
        if(addressResult == null)
        {
            shoppingCartService.insertAddress(address);
        }
        else
        {
            shoppingCartService.updateAddress(address);
        }
    }
}
