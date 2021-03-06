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

    /**
     * 查看某个商品的库存
     */
    Integer selectGoodsNumById(Integer goodsId);

    /**
     * 减库存
     */
    int updateStock(Integer goodsId);

    /**
     * 加库存
     */
    int updateAddStock(Integer goodsId);

    /**
     * 在Redis中查询该商品库存
     * @param goodsId
     * @return
     */
    int getStock(Integer goodsId);

    /**
     * 库存 -1
     * @param goodsId
     * @return
     */
    boolean decrStock(Integer goodsId);

    /**
     * 查询所有商品ID
     * @return
     */
    List<Integer> selectAllGoodsId();
}
