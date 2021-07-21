package com.example.controller;

import com.example.bean.Anonymous;
import com.example.service.AnonymousService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * 匿名墙
 */
@Api(tags = "AnonymousController", description = "匿名墙")
@RestController
public class AnonymousController {
    @Autowired
    private AnonymousService anonymousService;

    @ApiOperation(value = "查询所有匿名言论")
    @RequestMapping(value = "/selectAllAnonymous", produces = "application/json; charset=utf-8")
    public List<Anonymous> selectAllAnonymous() {
        return anonymousService.selectAllAnonymous();
    }

    @ApiOperation("根据ID查询匿名言论")
    @RequestMapping(value = "/selectAnonymousById", produces = "application/json; charset=utf-8")
    public List<Anonymous> selectAnonymousById(String wxId) {
        return anonymousService.selectAnonymousById(wxId);
    }

    @ApiOperation("发布匿名言论")
    @RequestMapping(value = "/insertAnonymous", method = RequestMethod.GET)
    public String insertAnonymous(Anonymous anonymous) {
        // 发布文章判断是否为空
        if (anonymous == null && "".equals(anonymous)) {
            return "发布内容不能为空";
        }

        anonymousService.insertAnonymous(anonymous);
        return "成功添加匿名文章";
    }

    @ApiOperation("删除匿名言论")
    @RequestMapping(value = "/deleteAnonymous", method = RequestMethod.GET)
    public String deleteAnonymous(Integer id) {
        anonymousService.deleteAnonymous(id);
        return "成功删除匿名言论";
    }

}
