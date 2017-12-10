package com.glory.dao.impl;

import com.glory.dao.ArticleDAO;
import com.glory.entity.Article;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class ArticleDAOImpl implements ArticleDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return this.sessionFactory.openSession();
    }

    @Override
    public Article load(Long id) {
        return (Article) getCurrentSession().load(Article.class, id);
    }

    @Override
    public Article get(Long id) {
        return (Article) getCurrentSession().get(Article.class, id);
    }

    @Override
    public List<Article> findAll() {
        return null;
    }

    @Override
    public void persist(Article entity) {
        getCurrentSession().persist(entity);
    }

    @Override
    public Long save(Article entity) {
        return (Long) getCurrentSession().save(entity);
    }

    @Override
    public void saveOrUpdate(Article entity) {
        getCurrentSession().saveOrUpdate(entity);
    }

    @Override
    public void delete(Long id) {
        Article person = load(id);
        getCurrentSession().delete(person);
    }

    @Override
    public void flush() {
        getCurrentSession().flush();
    }
}
