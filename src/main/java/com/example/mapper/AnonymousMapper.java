package com.example.mapper;

import com.example.bean.Anonymous;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnonymousMapper
{
    void insertAnonymous(Anonymous anonymous);

    void deleteAnonymous(Integer id);

    List<Anonymous> selectAnonymousById(String wxId);

    List<Anonymous> selectAllAnonymous();
}
