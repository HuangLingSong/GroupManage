package com.glory.dao;

import com.glory.entity.Chat;

import java.util.List;

public interface ChatDAO  {

    int findCount();

    List<Chat> findAll();

    List<Chat> findAll(int page, int pageSize);

    List<Chat> find(String hql);

    List<Chat> find(String hql, Object... params);

    Chat findById(int id);

    void update(Chat t);

    void delete(Chat t);

    void save(Chat t);
}
