package com.glory.dao;

import java.util.List;

/**
 * Created by Monster on 2017/12/4.
 */
public interface BaseDAO<T> {

    int findCount();

    List<T> findAll();

    List<T> findAll(int page, int pageSize);

    T findById(int id);

    void update(T t);

    void delete(T t);

    void save(T t);

    List<T> find(String hql);

    List<T> find(String hql, Object... params);
}
