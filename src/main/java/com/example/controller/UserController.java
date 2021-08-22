package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.bean.User;
import com.example.common.CommonResult;
import com.example.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.Duration;
import java.util.UUID;

/**
 * 商家后台用户管理
 */
@Api(tags = "UserController", description = "商家后台用户管理")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate redisTemplate;

    @ApiOperation("登录")
    @RequestMapping(value = "doSellerLogin", method = RequestMethod.GET)
    public ModelAndView doSellerLogin(HttpServletRequest request, HttpServletResponse response, String name, String password) {
        ModelAndView mv;

        User userResult = userService.searchUser(new User(name, password));

        if (userResult != null) {
            // 登录成功 存到cookie中
            /*
            String jsonString = JSONObject.toJSONString(userResult);
            jsonString = URLEncoder.encode("USER_LOGIN", jsonString);

            Cookie cookie = new Cookie("USER_LOGIN", jsonString);
            cookie.setPath("/");
            cookie.setMaxAge(60 * 30);
            response.addCookie(cookie);
            */

            // 根据当前电脑状态 cpu、内存、时间戳等生成的随机字符串
            // 生成token令牌
            String token = UUID.randomUUID() + "";

            // 存到Redis数据库
            // 以令牌为key，user为value，存30分钟
            redisTemplate.opsForValue().set(token, userResult, Duration.ofMinutes(30L));
            // 放到前端
            request.setAttribute("token", token);

            return new ModelAndView("faceLogin");
        }

        return new ModelAndView("error");
    }

    @ApiOperation("商家后台管理系统登出")
    @RequestMapping(value = "loginOut", method = RequestMethod.GET)
    public CommonResult loginOut(HttpServletRequest request) {
        // 如果令牌不对都进不来此方法

        String token = request.getHeader("token");
        // 删除Redis中的token
        Boolean delete = redisTemplate.delete(token);

        return new CommonResult(200, "注销成功", delete);
    }

    @ApiOperation("商家注册")
    @RequestMapping(value = "insertUser", method = RequestMethod.GET)
    public ModelAndView insertUser() {
        return new ModelAndView("insertUser");
    }

    @ApiOperation("添加商家信息商家")
    @RequestMapping(value = "doInsertUser", method = RequestMethod.GET)
    public ModelAndView doInsertUser(User user) {
        userService.insertUser(user);
        return new ModelAndView("faceInput");
    }

    @ApiOperation("跳转登录界面")
    @RequestMapping(value = "sellerLogin", method = RequestMethod.GET)
    public ModelAndView sellerLogin() {
        return new ModelAndView("sellerLogin");
    }

    @ApiOperation("后端商家主页")
    @RequestMapping(value = "sellerIndex", method = RequestMethod.GET)
    public ModelAndView sellerIndex() {
        return new ModelAndView("sellerIndex");
    }
}
