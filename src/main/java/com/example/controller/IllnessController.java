package com.example.controller;

import com.example.bean.Illness;
import com.example.bean.Pre;
import com.example.service.IllnessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class IllnessController
{
    @Autowired
    private IllnessService illnessService;

    // 查询返回json
    @RequestMapping(value = "/selectIllness", produces = "application/json; charset=utf-8")
    public Illness selectIllness(String wxId)
    {
        return illnessService.selectIllness(wxId);
    }

    @RequestMapping(value = "/selectOrder", produces = "application/json; charset=utf-8")
    public Pre selectIllness()
    {
        return illnessService.selectOrder();
    }

    // 添加
    @RequestMapping(value = "/insertIllness")
    public String insertAnonymous(Illness illness)
    {
        Pre pre = illnessService.selectOrder();
        if(illness.getType().equals("1"))
        {
            illnessService.updateshangwu1(pre.getShangwu1()-1);
        }
        else if(illness.getType().equals("2"))
        {
            illnessService.updateshangwu2(pre.getShangwu2()-1);
        }
        else if(illness.getType().equals("3"))
        {
            illnessService.updatexiawu1(pre.getXiawu1()-1);
        }
        else if(illness.getType().equals("4"))
        {
            illnessService.updatexiawu2(pre.getXiawu2()-1);
        }
        illnessService.insertIllness(illness);
        return "预订成功";
    }

    // 删除
    @RequestMapping(value = "/deleteIllness")
    public String deleteIllness(String wxId)
    {
        illnessService.deleteIllness(wxId);
        return "删除成功";
    }

}
