package com.example.service;

import com.example.bean.User;

public interface UserService
{
    void insertUser(User user);

    // 身份验证
    User searchUser(User user);
}
