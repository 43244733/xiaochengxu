package com.example.controller;

import com.example.bean.Address;
import com.example.bean.Shop;
import com.example.service.ShoppingCartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * 购物车管理
 */
@Api(tags = "ShoppingCartController", description = "购物车管理")
@RestController
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @ApiOperation("查询购物车商品")
    @RequestMapping(value = "/selectCart", produces = "application/json; charset=utf-8")
    public List<Shop> selectCart(String wxId) {
        return shoppingCartService.selectGoods(wxId);
    }

    @ApiOperation("添加至购物车")
    @RequestMapping(value = "/insertCart")
    public String insertCart(Integer gId, String wxId) {
        shoppingCartService.insertGoods(gId, wxId);
        return "成功添加至购物车";
    }

    @ApiOperation("购物车商品删除")
    @RequestMapping(value = "/deleteCart")
    public String deleteCart(Integer gId, String wxId) {
        shoppingCartService.deleteGoods(gId, wxId);
        return "成功删除";
    }

    @ApiOperation("查询待付款")
    @RequestMapping(value = "/selectWaitPaid", produces = "application/json; charset=utf-8")
    public List<Shop> selectWaitPaid(String wxId) {
        return shoppingCartService.selectWaitPaid(wxId);
    }

    @ApiOperation("查询已发货")
    @RequestMapping(value = "/selectWaitSend", produces = "application/json; charset=utf-8")
    public List<Shop> selectWaitSend(String wxId) {
        return shoppingCartService.selectWaitSend(wxId);
    }

    @ApiOperation("查询待评论")
    @RequestMapping(value = "/selectWaitMess", produces = "application/json; charset=utf-8")
    public List<Shop> selectWaitMess(String wxId) {
        return shoppingCartService.selectWaitMess(wxId);
    }

    @ApiOperation("修改到待付款")
    @RequestMapping(value = "/updatePaid")
    public String updatePaid(Integer gId, String wxId) {
        shoppingCartService.updatePaid(gId, wxId);
        return "待付款";
    }

    @ApiOperation("修改到待发货")
    @RequestMapping(value = "/updatePaidTwo")
    public String updatePaidTwo(Integer gId, String wxId) {
        shoppingCartService.insertPaid(gId, wxId);
        return "待发货";
    }

    @ApiOperation("修改到已发货")
    @RequestMapping(value = "/updateSend")
    public String updateSend(Integer gId, String wxId) {
        shoppingCartService.updateSend(gId, wxId);
        return "已发货";
    }

    @ApiOperation("修改到待评论")
    @RequestMapping(value = "/updateMess")
    public String updateMess(Integer gId, String wxId) {
        shoppingCartService.updateMess(gId, wxId);
        return "待评论";
    }

    @ApiOperation("查询地址")
    @RequestMapping(value = "/selectAddress")
    public Address selectAddress(String wxId) {
        return shoppingCartService.selectAddress(wxId);
    }

    @ApiOperation("添加或修改地址")
    @RequestMapping(value = "/updateAddress")
    public void updateAddress(Address address) {
        Address addressResult = shoppingCartService.selectAddress(address.getWxId());
        if (addressResult == null) {
            shoppingCartService.insertAddress(address);
        } else {
            shoppingCartService.updateAddress(address);
        }
    }
}
