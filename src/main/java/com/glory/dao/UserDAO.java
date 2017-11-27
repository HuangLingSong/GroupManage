package com.glory.dao;

import com.glory.entity.User;

import java.util.List;

/**
 * Created by Monster on 2017/10/25.
 */
public interface UserDAO {

    public User login(String username, String password);

    public User getUserByEmail(String email);

    public int register(User user);

    public List<User> getUser();

    public int delete(int id);

    public int edit(User user);

}
