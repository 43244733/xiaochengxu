package com.example.service;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class BloomFilterService {

    @Autowired
    private ShopService shopService;

    private BloomFilter<Integer> bf;

    /**
     * 程序启动时候加载此方法
     */
    @PostConstruct
    public void initBloomFilter() {
        List<Integer> idList = shopService.selectAllGoodsId();
        if (CollectionUtils.isEmpty(idList)) {
            return;
        }
        // 创建布隆过滤器（默认误差3%）
        bf = BloomFilter.create(Funnels.integerFunnel(), idList.size());
        // 将数据库中所有用户id压入布隆过滤器，存于JVM内存
        // idList.stream().forEach(id -> bf.put(id));

        // 使用并行流提高效率
        idList.parallelStream().forEach(id -> bf.put(id));
    }

    /**
     * 判断用户id是否存在于布隆过滤器
     */
    public boolean goodsIdExist(Integer goodsId) {
        return bf.mightContain(goodsId);
    }

}
