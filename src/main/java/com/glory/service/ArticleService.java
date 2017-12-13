package com.glory.service;

import com.glory.entity.Article;

import java.util.List;

/**
 * Created by XRom
 * On 11/16/2017.11:57 PM
 */
public interface ArticleService {

    public int save(Article article);

     public Article get(int id);

    public List<Article> findAll();

    public void delete(int id);

    public void saveOrUpdate(Article entity);


}
