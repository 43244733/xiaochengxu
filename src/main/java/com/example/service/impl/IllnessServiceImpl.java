package com.example.service.impl;

import com.example.bean.Illness;
import com.example.bean.Pre;
import com.example.mapper.IllnessMapper;
import com.example.service.IllnessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IllnessServiceImpl implements IllnessService
{
    @Autowired
    private IllnessMapper illnessMapper;

    @Override
    public void insertIllness(Illness illness)
    {
        illnessMapper.insertIllness(illness);
    }

    @Override
    public Illness selectIllness(String wxId)
    {
        return illnessMapper.selectIllness(wxId);
    }

    @Override
    public void deleteIllness(String wxId)
    {
        illnessMapper.deleteIllness(wxId);
    }

    @Override
    public Pre selectOrder()
    {
        return illnessMapper.selectOrder();
    }

    @Override
    public void updateshangwu1(Integer number)
    {
        illnessMapper.updateshangwu1(number);
    }

    @Override
    public void updateshangwu2(Integer number)
    {
        illnessMapper.updateshangwu2(number);
    }

    @Override
    public void updatexiawu1(Integer number)
    {
        illnessMapper.updatexiawu1(number);
    }

    @Override
    public void updatexiawu2(Integer number)
    {
        illnessMapper.updatexiawu2(number);
    }
}
