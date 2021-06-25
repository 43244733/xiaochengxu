package com.example.service;

import com.example.bean.Anonymous;
import java.util.List;

public interface AnonymousService
{
    void insertAnonymous(Anonymous anonymous);

    void deleteAnonymous(Integer id);

    List<Anonymous> selectAnonymousById(String wxId);

    List<Anonymous> selectAllAnonymous();
}
