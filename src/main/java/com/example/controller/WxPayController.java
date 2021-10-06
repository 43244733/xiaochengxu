package com.example.controller;

import com.example.bean.CallBack;
import com.example.bean.OrderInfo;
import com.example.bean.User;
import com.example.dao.WxPayDao;
import com.example.service.BloomFilterService;
import com.example.service.CallBackService;
import com.example.service.OrderInfoService;
import com.example.service.ShopService;
import com.example.util.RedisUtil;
import com.example.util.Sign;
import com.example.util.WxConstUtil;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@RestController
public class WxPayController {

    @Autowired
    private ShopService shopService;

    @Autowired
    private WxPayDao payDao;

    @Autowired
    private CallBackService callBackService;

    @Autowired
    private OrderInfoService orderInfoService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private BloomFilterService bloomFilterService;

    private static final Logger LOGGER = LoggerFactory.getLogger(WxPayController.class);

    @ApiOperation("支付成功，获取异步回调")
    @RequestMapping(value = "/success", method = RequestMethod.POST)
    @ResponseBody
    public String success(@RequestParam("app_id") Integer appId,
                          @RequestParam("trade_no") String tradeNo,
                          @RequestParam("in_trade_no") String inTradeNo,
                          @RequestParam("out_trade_no") String outTradeNo,
                          @RequestParam("trade_type") String tradeType,
                          @RequestParam("description") String description,
                          @RequestParam("pay_type") String payType,
                          @RequestParam("amount") Integer amount,
                          @RequestParam("attach") String attach,
                          @RequestParam("create_time") String createTime,
                          @RequestParam("pay_time") String payTime,
                          @RequestParam("notify_count") Integer notifyCount,
                          @RequestParam("sign") String signAfter
    ) throws UnknownHostException, ExecutionException, InterruptedException {
        // 验证数据签名

        OrderInfo orderInfo = orderInfoService.selectOrderById(Long.valueOf(outTradeNo));
        // TreeMap 有序
        Map<String, String> order = new TreeMap<>();

        order.put("amount", orderInfo.getGoodsPrice().stripTrailingZeros().toPlainString().trim());
        order.put("app_id", WxConstUtil.APP_ID);
        order.put("description", orderInfo.getGoodsName());

        // 回调方法
        // 获取本机IPV4地址
        String IPV4 = InetAddress.getLocalHost().getHostAddress();
        String notify_url = "http://" + IPV4 + "/success";
        order.put("notify_url", notify_url);

        // 商家订单编号
        order.put("out_trade_no", String.valueOf(orderInfo.getId()));
        order.put("pay_type", "wechat");

        // 通信密钥
        String sign = Sign.sign(order, WxConstUtil.KEY);

        if (sign.equals(signAfter)) {
            // 验证异步回调通知sign成功

            CompletableFuture<Boolean> completableFuture = CompletableFuture.supplyAsync(() -> {
                // 记录日志
                int insertCallBack = callBackService.insertCallBack(new CallBack(appId, tradeNo, inTradeNo, outTradeNo, tradeType, description,
                        payType, amount, attach, createTime, payTime, notifyCount));

                return insertCallBack > 0;
            });

            /*
            completableFuture.whenCompleteAsync((t, u) -> {
                if (t) {

                }
            }).exceptionally((u) -> {
                LOGGER.error(u.toString());
                return false;
            });
            */

            /**
             * 如果不使用.get(）方法阻塞 那么有可能会产生不安全问题：
             * CompletableFuture默认创建的是守护线程
             * 如果不使用.get()方法阻塞 那么当主线程执行完毕 可能守护线程就直接关闭了
             * 当然 生产环境上会一直开着 因此真是生产环境不会出现这种问题
             */

            // 订单加入支付时间 并修改订单状态为已支付
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = null;
            try {
                date = format.parse(payTime);
            } catch (ParseException e) {
                LOGGER.error("支付时间生成出错：", e);
            }
            orderInfoService.updatePayTime(date, Long.valueOf(outTradeNo));
            return "success";
        }

        return "false";
    }

/*
    @RequestMapping(value = "/buyGoods", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public Map buyGoods(@RequestParam Integer prices) {
        // 返回价格单位为 '分'
        Integer pay = prices * 100;
        // 用法示例
        Map<String, String> order = new TreeMap<String, String>();
        order.put("amount", String.valueOf(pay));
        order.put("app_id", APP_ID);
        order.put("description", "XiaoLianXiangYing");
        // 回调
        order.put("notify_url", "http://www.hututu777.cn/success");
        order.put("out_trade_no", "122");
        order.put("pay_type", "wechat");
        // 通信密钥
        String key = "7f36f8af1b6e19bd75c63584d8ca244b";
        sign s = new sign();
        String sign = s.sign(order, key);
        order.put("sign", sign);
        System.out.println(order);
        return order;
    }
    */

    @ApiOperation("生成订单，微信支付")
    @RequestMapping(value = "/buyGoods", method = RequestMethod.POST)
    @ResponseBody
    public Object buyGoods(@RequestParam(value = "recName") String recName,
                           @RequestParam(value = "recAddress") String recAddress,
                           @RequestParam(value = "recPhone") String recPhone,
                           @RequestParam(value = "goodsId") Integer goodsId,
                           @RequestParam(value = "goodsName") String goodsName,
                           @RequestParam(value = "goodsCount", defaultValue = "1") Integer goodsCount,
                           @RequestParam(value = "goodsPrice") BigDecimal goodsPrice,
                           HttpServletRequest request
    ) throws UnknownHostException {

        Map<String, String> wxOrder;

        // 获得用户信息 Cookie
        /*
        String userInfo;
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("USER_LOGIN")) {
                    userInfo = URLDecoder.decode(cookie.getValue(), "UTF-8");
                }
            }
        }
        */

        // 布隆过滤器
        boolean flag = bloomFilterService.goodsIdExist(goodsId);
        if (!flag) {
            return "该商品不存在，无法生成订单";
        }

        // token
        // 从请求头中获取数据
        String token = request.getHeader("token");
        token = token == null ? "" : token;
        // 利用过期时间查看登录状态 不允许token为空值
        Long expire = redisTemplate.getExpire(token);

        User user = null;
        if (expire > 0) { // 是登录状态
            // 重置token时间
            redisTemplate.expire(token, 30L, TimeUnit.MINUTES);
            user = (User) redisTemplate.opsForValue().get(token);
        } else {
            return "未登录";
        }

        Integer userId = user.getId();
        String userName = user.getName();

        // 判断库存
        boolean b = preOrder(userId, goodsId);
        if (!b) {
            return "库存不足";
        }

        // 下订单 微信支付
        wxOrder = payDao.wxPay(recName, recAddress, recPhone, goodsId, userId, userName, goodsCount,
                goodsPrice, goodsName);

        // 删除redis中的缓存
        redisTemplate.delete("goodsNums:" + goodsId);

        return wxOrder;


        /*
        // TreeMap 有序
        Map<String, String> order = new TreeMap<String, String>();
        order.put("amount", String.valueOf(prices));
        order.put("app_id", APP_ID);
        order.put("description", description);

        // 回调方法
        // 获取本机IPV4地址
        String IPV4 = InetAddress.getLocalHost().getHostAddress();
        String notify_url = "http://" + IPV4 + "/success";
        order.put("notify_url", notify_url);

        // 商家订单编号
        order.put("out_trade_no", "" + SequenceUtil.getInstance().nextId());
        order.put("pay_type", "wechat");

        // 通信密钥
        String key = "7f36f8af1b6e19bd75c63584d8ca244b";

        sign s = new sign();
        String sign = s.sign(order, key);
        order.put("sign", sign);
        */

    }

    /**
     * 判断库存是否足够
     *
     * @param userId
     * @param goodsId
     * @return
     */
    public boolean preOrder(Integer userId, Integer goodsId) {
        //判断库存是否足够
        int preStock = shopService.getStock(goodsId);
        if (preStock <= 0) {
            return false;
        }

        //先生成预订单，分布式锁，表示用户已经购买过了，否则并发情况下会产生重复购买的情况
        long result = redisTemplate.opsForSet().add(userId, goodsId);
        if (result != 1) {
            // 证明这个商品已经买过了 且没有进行支付
            return false;
        }

        //如果result == 1则成功，再扣库存
        boolean flag = decr(goodsId.toString());
        //可能存在并发情况，扣减之后的库存  < 0，表示库存扣减失败
        if (!flag) {
            //删除已经创建的预订单
            redisTemplate.opsForSet().pop(userId);
            return false;
        }
        //判断库存是否小于等于0
        int afterStock = shopService.getStock(goodsId);
        if (afterStock <= 0) {
            // TODO 更新标志位已售完
        }
        return true;
    }

    public boolean decr(String key) {
        redisTemplate.watch(key);
        String result = (String) redisUtil.get(key);
        if (StringUtils.isEmpty(result) || Integer.parseInt(result) <= 0) {
            //获取值，如果为0，则返回失败
            return false;
        }
        redisTemplate.multi(); // 开启事务
        redisTemplate.opsForValue().decrement(key);
        return !CollectionUtils.isEmpty(redisTemplate.exec()); //提交事务，如果此时key被改动了，则返回null，否则返回非空
    }

    public static void main(String[] args) {



        WxPayController wxPayController = new WxPayController();
     /*   Map map = null;
        try {
            map = (Map) wxPayController.buyGoods(1,100, "测试");
        }
        catch (UnknownHostException e) {
            e.printStackTrace();
        }*/

     /*   System.out.println(JSONObject.toJSONString(map));


        String s = HttpRequest.sendPost("https://open.h5zhifu.com/api/miniapp",
                JSONObject.toJSONString(map));

        System.out.println(s);*/

//        System.out.println(JavaPostJson.post("https://open.h5zhifu.com/api/miniapp", JSONObject.toJSONString(map)));
    }

}



