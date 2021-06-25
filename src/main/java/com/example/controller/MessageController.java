package com.example.controller;

import com.example.bean.Message;
import com.example.bean.ShoppingCart;
import com.example.service.MessageService;
import com.example.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@SpringBootApplication
public class MessageController
{
    @Autowired
    private MessageService messageService;

    @Autowired
    private ShoppingCartService shoppingCartService;

    // 增加
    @RequestMapping(value = "insertMessage", method = RequestMethod.GET)
    public ModelAndView insertMessage()
    {
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

    @RequestMapping(value = "doInsertMessage", method = RequestMethod.GET)
    public String doInsertArticle(Message message)
    {
        messageService.insertMessage(message);
        shoppingCartService.deleteGoods(message.getgId(), message.getWxId());
        return "评论成功";
    }

    // 查询返回json
    @RequestMapping(value = "/showMessage", produces = "application/json; charset=utf-8")
    public List<Message> showMessage(Integer gId)
    {
        return messageService.selectMessageByGId(gId);
    }

    // 查询
    @RequestMapping(value = "selectMessage", method = RequestMethod.GET)
    public ModelAndView selectMessage(HttpSession session, Integer gId)
    {
        ModelAndView mv = new ModelAndView("selectMessage");
        session.setAttribute("messageList", messageService.selectMessageByGId(gId));
        return mv;
    }

    // 删除
    @RequestMapping(value = "deleteMessage", method = RequestMethod.GET)
    public ModelAndView deleteMessage(Integer id, Integer gId)
    {
        ModelAndView mv = new ModelAndView("redirect:/selectMessage?gId=" + gId);
        messageService.deleteMessage(id);
        return mv;
    }
}
