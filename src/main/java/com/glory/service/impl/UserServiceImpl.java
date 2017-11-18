package com.glory.service.impl;


import com.glory.dao.UserDAO;
import com.glory.dao.impl.UserDAOImpl;
import com.glory.entity.Group;
import com.glory.entity.Role;
import com.glory.entity.User;
import com.glory.service.UserService;

import java.util.List;

/**
 * Created by Monster on 2017/10/27.
 */
public class UserServiceImpl implements UserService {

    UserDAO userDAO= new UserDAOImpl();

    @Override
    public User login(String username, String password) {

        return userDAO.login(username,password);
    }

    @Override
    public User getUserByEmail(String email) {

        return userDAO.getUserByEmail(email);
    }

    @Override
    public int register(User user) {
        return userDAO.register(user);
    }

    public List<User> getUser(){
        return userDAO.getUser();
    }




}
