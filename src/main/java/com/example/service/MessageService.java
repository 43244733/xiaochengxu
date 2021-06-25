package com.example.service;

import com.example.bean.Message;
import java.util.List;

public interface MessageService
{
    void insertMessage(Message message);

    List<Message> selectMessageByGId(Integer gId);

    void deleteMessage(Integer id);
}
