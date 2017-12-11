package com.glory.dao.impl;

import com.glory.dao.MessageDAO;
import com.glory.entity.Message;
import com.glory.libraries.DBManager;

/**
 * Created by Monster on 2017/11/18.
 */
public class MessageDAOImpl implements MessageDAO {

    DBManager dbManager = null;

    @Override
    public int forgotPasswd(Message message) {
        dbManager = new DBManager();
        int resultSet = 0;
        try {
            String sql = "insert into t_message (content) value (?)";
            resultSet = dbManager.doUpdate(sql, new Object[]{message.getContent()});
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbManager.CloseConnection();
        }
        return resultSet;
    }
}
