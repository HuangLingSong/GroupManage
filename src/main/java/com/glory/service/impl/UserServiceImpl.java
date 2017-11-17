package com.glory.service.impl;


import com.glory.dao.UserDAO;
import com.glory.dao.impl.UserDAOImpl;
import com.glory.entity.User;
import com.glory.service.UserService;

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
    public User getUserByName(String username) {

        return userDAO.getUserByName(username);
    }

    @Override
    public int signup(User user) {
        return userDAO.signup(user);
    }


}
