package com.glory.dao.impl;

import com.glory.dao.ArticleDAO;
import com.glory.entity.Article;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class ArticleDAOImpl implements ArticleDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return this.sessionFactory.openSession();
    }

    @Override
    public Article load(int id) {
        return (Article) getCurrentSession().load(Article.class, id);
    }

    @Override
    public Article get(int id) {
        return (Article) this.hibernateTemplate.get(Article.class,id);
    }

    @Override
    public List<Article> findAll() {
        return this.hibernateTemplate.loadAll(Article.class);
    }

    @Override
    public void persist(Article entity) {
        getCurrentSession().persist(entity);
    }

    @Override
    public int save(Article entity) {
        return (int) this.hibernateTemplate.save(entity);
    }

    @Override
    public void saveOrUpdate(Article entity) {
        getCurrentSession().saveOrUpdate(entity);
    }

    @Override
    public void delete(int id) {
        Article article = load(id);

        getCurrentSession().delete(article);
    }

    @Override
    public void flush() {
        getCurrentSession().flush();
    }


}
