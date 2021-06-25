package com.example.mapper;

import com.example.bean.Message;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageMapper
{
    void insertMessage(Message message);

    List<Message> selectMessageByGId(Integer gId);

    void deleteMessage(Integer id);
}
