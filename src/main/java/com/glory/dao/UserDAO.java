package com.glory.dao;

import com.glory.model.User;

import java.util.List;

/**
 * Created by Monster on 2017/10/25.
 */
public interface UserDAO {


//    用户登录
    public User login(String username, String password);


//    通过Email查找用户
    public User getUserByEmail(String email);

//    注册
    public int register(User user);


//    获取所有用户
    public List<User> getUser();


//  删除用户
    public int delete(int id);


//  编辑用户
    public int edit(User user);

}
