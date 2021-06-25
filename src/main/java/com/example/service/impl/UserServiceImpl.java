package com.example.service.impl;

import com.example.bean.User;
import com.example.mapper.UserMapper;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserMapper userMapper;

    @Override
    public void insertUser(User user)
    {
        userMapper.insertUser(user);
    }

    @Override
    public User searchUser(User user)
    {
        return userMapper.searchUser(user);
    }
}
