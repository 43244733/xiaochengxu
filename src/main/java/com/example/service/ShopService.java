package com.example.service;

import com.example.bean.Shop;

import java.util.List;

public interface ShopService
{
    List<Shop> selectAll();

    void deleteGoods(Integer id);

    void updateGoods(Shop shop);

    void insertGoods(Shop shop);

    Shop selectGoodsById(Integer id);

    List<Shop> selectAllById(Integer id);

    void updateFileUpload(String url, Integer id);

    Shop selectIdByName(String name);

    List<Shop> indexRecommend();

    List<Shop> selectHistoryTopSix(String wxId);

    void deleteHistory(String wxId);

    void insertHistory(Integer gId, String wxId);
}
