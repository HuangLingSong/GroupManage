package com.glory.dao;

import com.glory.entity.Article;

import java.util.List;


public interface ArticleDAO {

    Article load(int id);

    Article get(int id);

    List<Article> findAll();

    void persist(Article entity);

    int save(Article entity);

    void saveOrUpdate(Article entity);

    void delete(int id);

    void flush();
}
