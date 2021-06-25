package com.example.controller;

import com.example.bean.Anonymous;
import com.example.service.AnonymousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@SpringBootApplication
public class AnonymousController {
    @Autowired
    private AnonymousService anonymousService;

    // 查询返回json
    @RequestMapping(value = "/selectAllAnonymous", produces = "application/json; charset=utf-8")
    public List<Anonymous> selectAllAnonymous() {
        return anonymousService.selectAllAnonymous();
    }

    @RequestMapping(value = "/selectAnonymousById", produces = "application/json; charset=utf-8")
    public List<Anonymous> selectAnonymousById(String wxId) {
        return anonymousService.selectAnonymousById(wxId);
    }

    // 添加
    @RequestMapping(value = "/insertAnonymous")
    public String insertAnonymous(Anonymous anonymous) {
        // 发布文章判断是否为空
        if (anonymous == null && "".equals(anonymous)) {
            return "发布内容不能为空";
        }

        anonymousService.insertAnonymous(anonymous);
        return "成功添加匿名文章";
    }

    // 删除
    @RequestMapping(value = "/deleteAnonymous")
    public String deleteAnonymous(Integer id) {
        anonymousService.deleteAnonymous(id);
        return "成功删除匿名文章";
    }

}
