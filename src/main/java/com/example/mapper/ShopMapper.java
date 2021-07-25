package com.example.mapper;

import com.example.bean.Shop;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopMapper
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
}
