package com.example.mapper;

import com.example.model.Wxuser;
import com.example.model.WxuserExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WxuserMapper {
    long countByExample(WxuserExample example);

    int deleteByExample(WxuserExample example);

    int deleteByPrimaryKey(Integer wxid);

    int insert(Wxuser record);

    int insertSelective(Wxuser record);

    List<Wxuser> selectByExample(WxuserExample example);

    Wxuser selectByPrimaryKey(Integer wxid);

    int updateByExampleSelective(@Param("record") Wxuser record, @Param("example") WxuserExample example);

    int updateByExample(@Param("record") Wxuser record, @Param("example") WxuserExample example);

    int updateByPrimaryKeySelective(Wxuser record);

    int updateByPrimaryKey(Wxuser record);
}