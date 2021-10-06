package com.example.service.impl;

import com.example.bean.Shop;
import com.example.mapper.ShopMapper;
import com.example.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService
{
    @Autowired
    private ShopMapper shopMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public int getStock(Integer goodsId) {
        return (int) redisTemplate.opsForValue().get(goodsId);
    }

    @Override
    public boolean decrStock(Integer goodsId) {
        Long decrement = redisTemplate.opsForValue().decrement(goodsId);
        return decrement >= 0;
    }

    @Override
    public List<Integer> selectAllGoodsId() {
        return shopMapper.selectAllGoodsId();
    }

    @Override
    public List<Shop> selectAll()
    {
        return shopMapper.selectAll();
    }

    @Override
    public void deleteGoods(Integer id)
    {
        shopMapper.deleteGoods(id);
    }

    @Override
    public void updateGoods(Shop shop)
    {
        shopMapper.updateGoods(shop);
    }

    @Override
    public void insertGoods(Shop shop)
    {
        shopMapper.insertGoods(shop);
    }

    @Override
    public Shop selectGoodsById(Integer id)
    {
        return shopMapper.selectGoodsById(id);
    }

    @Override
    public List<Shop> selectAllById(Integer id)
    {
        return shopMapper.selectAllById(id);
    }

    @Override
    public void updateFileUpload(String url, Integer id)
    {
        shopMapper.updateFileUpload(url,id);
    }

    @Override
    public Shop selectIdByName(String name)
    {
        return shopMapper.selectIdByName(name);
    }

    @Override
    public List<Shop> indexRecommend()
    {
        return shopMapper.indexRecommend();
    }

    @Override
    public List<Shop> selectHistoryTopSix(String wxId)
    {
        return shopMapper.selectHistoryTopSix(wxId);
    }

    @Override
    public void deleteHistory(String wxId)
    {
        shopMapper.deleteHistory(wxId);
    }

    @Override
    public void insertHistory(Integer gId, String wxId)
    {
        shopMapper.insertHistory(gId, wxId);
    }

    @Override
    public Integer selectGoodsNumById(Integer goodsId) {
        return shopMapper.selectGoodsNumById(goodsId);
    }

    @Override
    public int updateStock(Integer goodsId) {
        return shopMapper.updateStock(goodsId);
    }

    @Override
    public int updateAddStock(Integer goodsId) {
        return shopMapper.updateAddStock(goodsId);
    }


}
