package com.example.service.impl;

import com.example.bean.Message;
import com.example.mapper.MessageMapper;
import com.example.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService
{
    @Autowired
    private MessageMapper messageMapper;

    @Override
    public void insertMessage(Message message)
    {
        messageMapper.insertMessage(message);
    }

    @Override
    public List<Message> selectMessageByGId(Integer gId)
    {
        return messageMapper.selectMessageByGId(gId);
    }

    @Override
    public void deleteMessage(Integer id)
    {
        messageMapper.deleteMessage(id);
    }
}
