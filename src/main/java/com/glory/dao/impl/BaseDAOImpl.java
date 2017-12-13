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

//    @SuppressWarnings("unchecked")
//    public BaseDAOImpl(){
//        Type grnType = getClass().getGenericSuperclass();
//        Type[] parames = ((ParameterizedType) grnType).getActualTypeArguments();
//        entityClass = (Class<T>) parames[0];
//    }

    @Override
    public int findCount() {
        String hql = "SELECT count(*) from "+entityClass.getName();
        System.out.print("count: " +hql);
        List<Long> list  = (List<Long>) this.hibernateTemplate.find(hql);
        if (list.size()>0){
            return list.get(0).intValue();
        }
        return 0;
    }

    @Override
    public List<T> findAll() {
        return this.hibernateTemplate.loadAll(entityClass);
    }

    @Override
    public List<T> findAll(int page, int pageSize) {
        return null;
    }

    @Override
    public List<T> find(String hql) {
        return (List<T>) this.hibernateTemplate.find(hql);
    }

    @Override
    public List<T> find(String hql, Object... params) {
        return (List<T>) this.hibernateTemplate.find(hql,params);
    }

    @Override
    public T findById(int id) {
        return (T) this.hibernateTemplate.get(entityClass,id);
    }

    @Override
    public void update(T entity) {
        this.hibernateTemplate.update(entity);
    }

    @Override
    public void delete(T entity) {
        this.hibernateTemplate.delete(entity);
    }

    @Override
    public void save(T entity) {
        this.hibernateTemplate.save(entity);
    }

}
