package com.glory.dao.impl;

import com.glory.dao.BaseDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Monster on 2017/12/5.
 */
@Repository
public class BaseDAOImpl<T> implements BaseDAO<T> {

    private Class<T> entityClass;

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @SuppressWarnings("unchecked")
    public BaseDAOImpl(){
//        Type grnType = getClass().getGenericSuperclass();
//        Type[] parames = ((ParameterizedType) grnType).getActualTypeArguments();
//        entityClass = (Class<T>) parames[0];
    }

    @Override
    public int findCount() {

        return 0;
    }

    @Override
    public List<T> findAll() {
        return null;
    }

    @Override
    public List<T> findAll(int page, int pageSize) {
        return null;
    }

    @Override
    public T findById(int id) {
        return (T) this.hibernateTemplate.get(entityClass,id);
    }

    @Override
    public void update(T t) {

    }

    @Override
    public void delete(T t) {

    }

    @Override
    public void save(T t) {

    }

    @Override
    public List<T> find(String hql) {
        return null;
    }

    @Override
    public List<T> find(String hql, Object... params) {
        return null;
    }
}
