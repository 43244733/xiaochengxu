package com.example.controller;

import com.example.bean.User;
import com.example.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpSession;

/**
 * 商家后台用户管理
 */
@Api(tags = "UserController", description = "商家后台用户管理")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("商家注册")
    @RequestMapping(value = "insertUser", method = RequestMethod.GET)
    public ModelAndView insertUser() {
        ModelAndView mv = new ModelAndView("insertUser");
        return mv;
    }

    @ApiOperation("添加商家信息商家")
    @RequestMapping(value = "doInsertUser", method = RequestMethod.GET)
    public ModelAndView doInsertUser(User user) {
//        ModelAndView mv = new ModelAndView("redirect:/sellerLogin");
        userService.insertUser(user);
        ModelAndView mv = new ModelAndView("faceInput");
        return mv;
    }

    @ApiOperation("跳转登录界面")
    @RequestMapping(value = "sellerLogin", method = RequestMethod.GET)
    public ModelAndView sellerLogin() {
        ModelAndView mv = new ModelAndView("sellerLogin");
        return mv;
    }

    @ApiOperation("登录")
    @RequestMapping(value = "doSellerLogin", method = RequestMethod.GET)
    public ModelAndView doSellerLogin(HttpSession session, String name, String password) {
        User user = new User(name, password);
        ModelAndView mv;
        User userResult = userService.searchUser(user);
        if (userResult != null) {
            session.setAttribute("userLogin", userResult);
//            mv = new ModelAndView("sellerIndex");
            mv = new ModelAndView("faceLogin");
        } else {
            mv = new ModelAndView("error");
        }
        return mv;
    }

    @ApiOperation("后端商家主页")
    @RequestMapping(value = "sellerIndex", method = RequestMethod.GET)
    public ModelAndView sellerIndex(HttpSession session, String name, String password) {
        ModelAndView mv = new ModelAndView("sellerIndex");
        return mv;
    }
}
