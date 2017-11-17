package com.glory.service;

import com.glory.entity.User;

/**
 * Created by Monster on 2017/10/27.
 */
public interface UserService {

    public User login(String username, String password);

    public User getUserByName(String username);

    public int signup(User user);

}
