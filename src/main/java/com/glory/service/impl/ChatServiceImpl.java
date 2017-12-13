package com.glory.service.impl;

import com.glory.dao.ChatDAO;
import com.glory.dao.impl.ChatDAOImpl;
import com.glory.entity.Chat;
import com.glory.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ChatServiceImpl implements ChatService {

    @Autowired(required = true)
    private ChatDAO chatDAO = new ChatDAOImpl();

    @Override
    public Chat findById(int id) {
        return chatDAO.findById(id);
    }

    public List<Chat> getNewMessage(String preMsgTime){
        String hql="from Chat where createAt > ?";
        return chatDAO.find(hql,preMsgTime);
    }

    @Override
    public void savaMessage(Chat chat) {
        chatDAO.save(chat);
    }
}
