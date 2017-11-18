package com.glory.dao.impl;


import com.glory.dao.UserDAO;
import com.glory.entity.Group;
import com.glory.entity.Role;
import com.glory.entity.User;
import com.glory.libraries.DBManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
            while (resultSet.next()) {
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
    public User getUserByEmail(String email) {
        User user = null;
        dbManager = new DBManager();
        try {
            String sql = "select *from t_users where email =?";
            ResultSet resultSet = dbManager.doQurey(sql, new Object[]{email});
            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setEamil(resultSet.getString("email"));
                user.setUsername(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                user.setRoleId(resultSet.getInt("role_id"));
                user.setGroupId(resultSet.getInt("group_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbManager.CloseConnection();
        }
        return user;
    }

    @Override
    public int register(User user) {
        dbManager = new DBManager();
        int resultSet = 0;
        try {
            String sql = "insert into t_users (name,email,password,create_at) value (?,?,?,now())";
            resultSet = dbManager.doUpdate(sql, new Object[]{user.getUsername(), user.getEamil(), user.getPassword()});
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbManager.CloseConnection();
        }
        return resultSet;
    }

    public List<User> getUser() {

        List<User> list = new ArrayList<User>();
        dbManager = new DBManager();
        try {
            String sql = "select *from t_users ";
            ResultSet resultSet = dbManager.doQurey(sql, null);
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setEamil(resultSet.getString("email"));
                user.setUsername(resultSet.getString("name"));
                user.setCreateAt(resultSet.getString("create_at"));
                user.setRoleId(resultSet.getInt("role_id"));
                user.setGroupId(resultSet.getInt("group_id"));
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbManager.CloseConnection();
        }
        return list;
    }

    @Override
    public int delete(int id) {
        dbManager = new DBManager();
        int resultSet = 0;
        try {
            String sql = "delete from t_users where id = ?";
            resultSet = dbManager.doUpdate(sql, new Object[]{id});
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbManager.CloseConnection();
        }
        return resultSet;
    }

    public int edit(User user){
        dbManager = new DBManager();
        int resultSet = 0;
        try {
            String sql = "UPDATE t_users set role_id= ?,group_id = ? WHERE id = ?";
            resultSet = dbManager.doUpdate(sql, new Object[]{user.getRoleId(),user.getGroupId(),user.getId()});
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbManager.CloseConnection();
        }
        return resultSet;
    }


}
