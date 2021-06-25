package com.example.mapper;

import com.example.bean.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper
{
    void insertUser(User user);

    User searchUser(User user);
}
