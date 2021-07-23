package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.example.bean.Shop;
import com.example.service.ElasticSearchService;
import com.example.service.SerachBase;
import com.example.service.ShopService;
import com.example.util.ElasticSearchUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

/**
 * 商品搜索
 */
@Api(tags = "SearchController", description = "商品搜索")
@RestController
public class SearchController {

    @Autowired
    private ShopService shopService;

    @Autowired
    private ElasticSearchService elasticSearchService;

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @ApiOperation("ElasticSearch")
    @RequestMapping(value = "/search", produces = "application/json; charset=utf-8")
    public List<Shop> search(String input) throws IOException {
        SearchRequest searchRequest = new SearchRequest(ElasticSearchUtil.ES_INDEX);
        // 构造搜索条件
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();

        // 查询条件 我们可以使用 QueryBuilder 工具来实现
        // QueryBuilders.termQuery 精确查询
        // QueryBuilders.matchQuery() 匹配所有
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("name", input);
        // MatchAllQueryBuilder matchAllQueryBuilder = QueryBuilders.matchAllQuery();

        // 返回指定字段
        sourceBuilder
                .query(termQueryBuilder)
                .timeout(new TimeValue(60, TimeUnit.SECONDS))
                .fetchSource(new String[]{"id", "name"}, new String[]{""});


        searchRequest.source(sourceBuilder);

        SearchResponse response = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);

        List<Shop> shopList = new CopyOnWriteArrayList<>();

        for (SearchHit documentFields : response.getHits()) {
            Map<String, Object> sourceAsMap = documentFields.getSourceAsMap();
            shopList.add(new Shop((Integer) sourceAsMap.get("id"), (String) sourceAsMap.get("name")));
        }

        return shopList;
    }

    /**
     * 每天 0:00 进行同步操作
     * @return
     * @throws IOException
     */
    @Scheduled(cron = "0 0 0 1/1 * ? ")
    @ApiOperation("每天定时把Mysql中的数据同步到ES中")
    @RequestMapping("/mysql2ES")
    public Boolean mysql2ES() throws IOException {
        return elasticSearchService.inputMySql2ES();
    }

/*    @ApiOperation("模糊搜索")
    @RequestMapping(value = "/search", produces = "application/json; charset=utf-8")
    public List<Shop> search(String input) {
        SerachBase serachBase = SerachBase.getSerachBase();
        List<Shop> shops = shopService.selectAll();
        for (int i = 0; i < shops.size(); i++) {
            String id = String.valueOf(shops.get(i).getId());
            String value = shops.get(i).getName();
            serachBase.add(id, value, value);
        }
        String ids = serachBase.getIds(input);

        *//**
     //     * @param ids
     //     * @Description: 根据ids获取详细，id之间用","隔开
     *//*

        if (ids == null || "".equals(ids)) {
            return null;
        }
        List<Shop> objs = new ArrayList<>();
        String[] idArray = ids.split(",");
        for (String id : idArray) {
            Shop shop = shopService.selectGoodsById(Integer.valueOf(id));
            objs.add(shop);
        }
        return objs;
    }*/


}
