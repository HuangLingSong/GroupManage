package com.glory.dao;


import com.glory.entity.User;

/**
 * Created by Monster on 2017/10/25.
 */
public interface UserDAO {

    public User login(String username, String password);

    public User getUserByName(String username);

    public int signup(User user);
}
