package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.example.bean.CallBack;
import com.example.bean.OrderInfo;
import com.example.dao.WxPayDao;
import com.example.service.CallBackService;
import com.example.service.OrderInfoService;
import com.example.service.ShopService;
import com.example.util.Sign;
import com.example.util.WxConstUtil;
import com.google.gson.Gson;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

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

    private static final Logger LOGGER = LoggerFactory.getLogger(WxPayController.class);

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
    ) throws ParseException, UnknownHostException {
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

            // 记录日志
            callBackService.insertCallBack(new CallBack(appId, tradeNo, inTradeNo, outTradeNo, tradeType, description,
                    payType, amount, attach, createTime, payTime, notifyCount));

            DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = format.parse(payTime);

            // 订单模块加入支付时间
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
                           @RequestParam(value = "goodsPrice") BigDecimal goodsPrice
    ) throws UnknownHostException {

        Map<String, String> wxOrder;

        // TODO
        // 获得用户信息
        Integer userId = 1;
        String userName = "nihao";

        // 判断库存
        Integer stock = shopService.selectGoodsNumById(goodsId);
        if (stock <= 0) {
            return "库存不足";
        }

        // 减库存
        int i = shopService.updateStock(goodsId);
        if (i >= 1) {
            // 下订单 微信支付
            wxOrder = payDao.wxPay(recName, recAddress, recPhone, goodsId, userId, userName, goodsCount,
                    goodsPrice, goodsName);
        } else {
            return "库存不足";
        }

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


