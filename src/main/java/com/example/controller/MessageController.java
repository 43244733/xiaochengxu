package com.example.controller;

import com.example.bean.Message;
import com.example.service.MessageService;
import com.example.service.ShoppingCartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 商品评论
 */
@Api(tags = "MessageController", description = "商品评论")
@RestController
public class MessageController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private ShoppingCartService shoppingCartService;

    @ApiOperation("跳转发表评论页面")
    @RequestMapping(value = "insertMessage", method = RequestMethod.GET)
    public ModelAndView insertMessage() {
        ModelAndView mv = new ModelAndView("insertMessage");
        return mv;
    }

    /*@RequestMapping(value = "doInsertMessage", method = RequestMethod.GET)
    public ModelAndView doInsertArticle(Message message)
    {
        messageService.insertMessage(message);
        *//* 需要改跳转路径 *//*
        ModelAndView mv = new ModelAndView("redirect:/selectAllMessage");
        return mv;
    }*/

    @ApiOperation("添加评论")
    @RequestMapping(value = "doInsertMessage", method = RequestMethod.GET)
    public String doInsertMessage(Message message) {
        messageService.insertMessage(message);
        shoppingCartService.deleteGoods(message.getgId(), message.getWxId());
        return "评论成功";
    }

    @ApiOperation("根据ID查询评价")
    @RequestMapping(value = "/showMessage", produces = "application/json; charset=utf-8")
    public List<Message> showMessage(Integer gId) {
        return messageService.selectMessageByGId(gId);
    }

    @ApiOperation("跳转展示评论页面")
    @RequestMapping(value = "selectMessage", method = RequestMethod.GET)
    public ModelAndView selectMessage(HttpSession session, Integer gId) {
        ModelAndView mv = new ModelAndView("selectMessage");
        session.setAttribute("messageList", messageService.selectMessageByGId(gId));
        return mv;
    }

    @ApiOperation("删除评论信息")
    @RequestMapping(value = "deleteMessage", method = RequestMethod.GET)
    public ModelAndView deleteMessage(Integer id, Integer gId) {
        ModelAndView mv = new ModelAndView("redirect:/selectMessage?gId=" + gId);
        messageService.deleteMessage(id);
        return mv;
    }
}
