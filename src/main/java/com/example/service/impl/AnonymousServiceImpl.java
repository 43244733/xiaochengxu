package com.example.service.impl;

import com.example.bean.Anonymous;
import com.example.mapper.AnonymousMapper;
import com.example.service.AnonymousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnonymousServiceImpl implements AnonymousService
{
    @Autowired
    private AnonymousMapper anonymousMapper;


    @Override
    public void insertAnonymous(Anonymous anonymous)
    {
        anonymousMapper.insertAnonymous(anonymous);
    }

    @Override
    public void deleteAnonymous(Integer id)
    {
        anonymousMapper.deleteAnonymous(id);
    }

    @Override
    public List<Anonymous> selectAnonymousById(String wxId)
    {
        return anonymousMapper.selectAnonymousById(wxId);
    }

    @Override
    public List<Anonymous> selectAllAnonymous()
    {
        return anonymousMapper.selectAllAnonymous();
    }
}
