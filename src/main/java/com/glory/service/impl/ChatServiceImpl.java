package com.glory.service.impl;

import com.glory.dao.ChatDAO;
import com.glory.dao.impl.ChatDAOImpl;
import com.glory.entity.Chat;
import com.glory.service.ChatService;
import org.springframework.stereotype.Service;

/**
 * Created by Monster on 2017/12/4.
 */

@Service("chatService")
public class ChatServiceImpl implements ChatService {

    private ChatDAO chatDAO = new ChatDAOImpl();

    @Override
    public Chat findById(int id) {
        Chat chat = chatDAO.findById(id);
        return chat;
    }
}
