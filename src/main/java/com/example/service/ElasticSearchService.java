package com.example.service;

import com.alibaba.fastjson.JSON;
import com.example.bean.Shop;
import com.example.util.ElasticSearchUtil;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ElasticSearchService {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Autowired
    private ShopService shopService;

    /**
     * 解析数据 放入ES中
     */
    public Boolean inputMySql2ES() throws IOException {
        List<Shop> shops = shopService.selectAll();

        // 把查询到的数据放入ES中
        BulkRequest bulkRequest = new BulkRequest();
        bulkRequest.timeout("2m");

        for (int i = 0; i < shops.size(); i++) {
            bulkRequest.add(
                    new IndexRequest(ElasticSearchUtil.ES_INDEX)
                            .source(JSON.toJSONString(shops.get(i)), XContentType.JSON));
        }

        BulkResponse bulk = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);

        return !bulk.hasFailures();
    }
}
