package com.example.controller;

import com.example.bean.Illness;
import com.example.bean.Pre;
import com.example.service.IllnessService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 疫情防控
 */
@Api(tags = "IllnessController", description = "疫情防控")
@RestController
public class IllnessController {

    @Autowired
    private IllnessService illnessService;

    @ApiOperation("查询所有疫情预约信息")
    @RequestMapping(value = "/selectIllness", produces = "application/json; charset=utf-8", method = RequestMethod.GET)
    public Illness selectIllness(String wxId) {
        return illnessService.selectIllness(wxId);
    }

    @ApiOperation("查询所有预约时间信息")
    @RequestMapping(value = "/selectOrder", produces = "application/json; charset=utf-8")
    public Pre selectAllIllness() {
        return illnessService.selectOrder();
    }

    @ApiOperation("添加预约信息")
    @RequestMapping(value = "/insertIllness")
    public String insertIllness(Illness illness) {
        Pre pre = illnessService.selectOrder();
        if (illness.getType().equals("1")) {
            illnessService.updateshangwu1(pre.getShangwu1() - 1);
        } else if (illness.getType().equals("2")) {
            illnessService.updateshangwu2(pre.getShangwu2() - 1);
        } else if (illness.getType().equals("3")) {
            illnessService.updatexiawu1(pre.getXiawu1() - 1);
        } else if (illness.getType().equals("4")) {
            illnessService.updatexiawu2(pre.getXiawu2() - 1);
        }
        illnessService.insertIllness(illness);
        return "预订成功";
    }

    @ApiOperation("删除预约信息")
    @RequestMapping(value = "/deleteIllness")
    public String deleteIllness(String wxId) {
        illnessService.deleteIllness(wxId);
        return "删除成功";
    }

}
