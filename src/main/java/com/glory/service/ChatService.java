package com.glory.service;

import com.glory.controller.ChatController;
import com.glory.entity.Chat;

import java.util.List;

public interface ChatService {

    public Chat findById(int id);

    public List<Chat> getNewMessage(String preMsgTime);

    public void savaMessage(Chat chat);
}
