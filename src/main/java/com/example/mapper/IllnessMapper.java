package com.example.mapper;

import com.example.bean.Illness;
import com.example.bean.Pre;
import org.springframework.stereotype.Repository;

@Repository
public interface IllnessMapper
{
    void insertIllness(Illness illness);

    Illness selectIllness(String wxId);

    void deleteIllness(String wxId);

    Pre selectOrder();

    void updateshangwu1(Integer number);

    void updateshangwu2(Integer number);

    void updatexiawu1(Integer number);

    void updatexiawu2(Integer number);
}
