package com.glory.service.impl;

import com.glory.dao.MessageDAO;
import com.glory.dao.impl.MessageDAOImpl;
import com.glory.entity.Message;
import com.glory.service.MessageService;

/**
 * Created by Monster on 2017/11/18.
 */
public class MessageServiceImpl implements MessageService {

    MessageDAO messageDAO = new MessageDAOImpl();

    @Override
    public int forgotPasswd(Message message) {
        return messageDAO.forgotPasswd(message);
    }
}
