package com.glory.dao.impl;


import com.glory.dao.UserDAO;
import com.glory.entity.User;
import com.glory.libraries.DBManager;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Monster on 2017/10/27.
 */
public class UserDAOImpl implements UserDAO {

    DBManager dbManager = null;

    @Override
    public User login(String username, String password) {
        User user = null;
        dbManager = new DBManager();
        try {
            String sql = "select *from t_users where username=? and password=?";
            ResultSet resultSet = dbManager.doQurey(sql, new Object[]{username, password});
            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbManager.CloseConnection();
        }
        return user;
    }

    @Override
    public User getUserByName(String username) {
        User user = null;
        dbManager = new DBManager();
        try {
            String sql = "select *from t_users where username=?";
            ResultSet resultSet = dbManager.doQurey(sql, new Object[]{username});
            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbManager.CloseConnection();
        }
        return user;
    }

    @Override
    public int signup(User user) {
        dbManager = new DBManager();
        int resultSet = 0;
        try {
            String sql = "insert into t_users (username,password) value (?,?,?)";
            resultSet = dbManager.doUpdate(sql, new Object[]{user.getUsername(), user.getPassword()});
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbManager.CloseConnection();
        }
        return resultSet;
    }
}
