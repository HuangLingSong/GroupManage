package com.glory.dao.impl;

import com.glory.dao.ChatDAO;
import com.glory.entity.Chat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class ChatDAOImpl  implements ChatDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public int findCount() {
        return 0;
    }

    @Override
    public List<Chat> findAll() {
        return null;
    }

    @Override
    public List<Chat> findAll(int page, int pageSize) {
        return null;
    }

    @Override
    public List<Chat> find(String hql) {
        return null;
    }

    @Override
    public List<Chat> find(String hql, Object... params) {
        return (List<Chat>) this.hibernateTemplate.find(hql,params);
    }

    @Override
    public Chat findById(int id) {
        return null;
    }

    @Override
    public void update(Chat t) {

    }

    @Override
    public void delete(Chat t) {

    }

    @Override
    public void save(Chat t) {
        this.hibernateTemplate.save(t);
    }
}
