package com.example.controller;

import com.example.bean.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RestController
@SpringBootApplication
public class UserController
{
    @Autowired
    private UserService userService;

    // 注册
    @RequestMapping(value = "insertUser", method = RequestMethod.GET)
    public ModelAndView doInsertUser()
    {
        ModelAndView mv = new ModelAndView("insertUser");
        return mv;
    }

    @RequestMapping(value = "doInsertUser", method = RequestMethod.GET)
    public ModelAndView doInsertUser(User user)
    {
        ModelAndView mv = new ModelAndView("redirect:/sellerLogin");
        userService.insertUser(user);
        return mv;
    }

    // 主页
    @RequestMapping(value = "sellerIndex", method = RequestMethod.GET)
    public ModelAndView insertArticle(HttpSession session, String name, String password)
    {
        ModelAndView mv = new ModelAndView("sellerIndex");
        return mv;
    }

}
