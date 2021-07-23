package com.example;

import com.alibaba.fastjson.JSON;
import com.example.bean.Shop;
import com.example.bean.User;
import com.example.controller.CustomerServiceController;
import com.example.service.ShopService;
import com.example.util.ElasticSearchUtil;
import com.example.util.RedisUtil;
import io.swagger.annotations.ApiOperation;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
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
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

@SpringBootTest
class SpringbootRedisApplicationTests {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Autowired
    private ShopService shopService;

//    private static final ScheduledExecutorService batchTaskPool = Executors.newScheduledThreadPool(3);

    ExecutorService threadPool = Executors.newFixedThreadPool(3);

    /**
     * 解析数据 放入ES中
     */
    @Test
    void search() throws IOException {
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

        System.out.println(!bulk.hasFailures());

    }

    @Test
    void search1() throws IOException {
        SearchRequest searchRequest = new SearchRequest(ElasticSearchUtil.ES_INDEX);
        // 构造搜索条件
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();

        // 查询条件 我们可以使用 QueryBuilder 工具来实现
        // QueryBuilders.termQuery 精确查询
        // QueryBuilders.matchQuery() 匹配所有
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("name", "彪");
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

        System.out.println(shopList);
    }

    @Test
    void contextLoads() {
//        System.out.println(redisUtil.get("myKey"));
//        redisTemplate.opsForValue().set("myKey","myValue");
//        System.out.println(redisTemplate.opsForValue().get("myKey1"));
//        System.out.println(redisUtil.get("myKey1"));
//        System.out.println(redisUtil.get("myKey"));
        System.out.println(redisUtil.set("nihao", "nihuai"));
        System.out.println(redisUtil.get("nihao"));
    }

    @Test
    void test1() {
        User acceptUser = new User("ninini", "11111");
        User sendUser = new User("wowowo", "11111");
        String[] messages = new String[]{"asdadaddddd"};

        String key = acceptUser.getName() + ":msg";

        //将消息的内容加上消息的发送人以 *-* 分割，不能用增强for循环
        for (int i = 0, length_1 = messages.length; i < length_1; i++) {
            messages[i] = sendUser.getName() + "*-*" + messages[i];
        }

        // 传入消息队列
        Long lpushCount = redisUtil.lLeftPushAll(key, messages);  //返回值是还有多少消息未消费

        System.out.println("lpushCount: " + lpushCount);
        System.out.println(key);
        System.out.println(messages);
    }

    @Test
    void test2() {
        User acceptUser = new User("ninini", "11111");
        System.out.println(acceptUser.getName() + ":msg");
        //新建一个线程，线程池获取消息
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                while (true) {
//                    // 0是timeout, 返回的是一个集合，第一个是消息的key，第二个是消息的内容
//                    String message = redisUtil.lBRightPop(acceptUser.getName() + ":msg", 0, TimeUnit.SECONDS);
//                    System.out.println(message);
//
//                    String sendUserName = message.substring(0, message.indexOf("*-*"));//获取消息的发送者
//                    message = message.substring(message.indexOf("*-*") + 3);//获取消息内容
//
//                    System.out.println(acceptUser.getName() + " -> 收到 -> " + sendUserName + ":" + message);
//
////                    log.info("ThreadName is {},user {} consumer message {} ,sended by {}", Thread.currentThread().getName(), acceptUser.getUsername(), message, sendUserName);
//                }
//            }
//        };
//
//        //线程池中获取消息
//        //第一个参数是需要执行的任务，第二个参数是第一次的延迟时间，第三个参数是两次执行的时间间隔，第四个参数是时间的单位
//        batchTaskPool.scheduleWithFixedDelay(runnable, 3, 5, TimeUnit.SECONDS);

        threadPool.execute(() -> {
            while (true) {
                // 0是timeout, 返回的是一个集合，第一个是消息的key，第二个是消息的内容
                String message = redisUtil.lBRightPop(acceptUser.getName() + ":msg", 0, TimeUnit.SECONDS);
                System.out.println(message);

                String sendUserName = message.substring(0, message.indexOf("*-*"));//获取消息的发送者
                message = message.substring(message.indexOf("*-*") + 3);//获取消息内容

                System.out.println(acceptUser.getName() + " -> 收到 -> " + sendUserName + ":" + message);

//                    log.info("ThreadName is {},user {} consumer message {} ,sended by {}", Thread.currentThread().getName(), acceptUser.getUsername(), message, sendUserName);
            }
        });


    }

    @Test
    void test3() {
//        System.out.println(redisUtil.lBRightPop("ninini:msg", 0, TimeUnit.SECONDS));
        for (int i = 0; i < 10; i++) {
            threadPool.execute(() -> {
                System.out.println(Thread.currentThread().getName());
            });
        }

    }
}
