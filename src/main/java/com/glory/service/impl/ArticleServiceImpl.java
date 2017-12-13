package com.glory.service.impl;

import com.glory.entity.Article;
import com.glory.dao.ArticleDAO;
import com.glory.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by XRom
 * On 11/16/2017.11:58 PM
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired(required = true)
    private ArticleDAO articleDAO;


    @Override
    public int save(Article article) {
        return articleDAO.save(article);
    }

    @Override
    public Article get(int id) {
        return articleDAO.get(id);
    }

    @Override
    public List<Article> findAll() {

        return articleDAO.findAll();
    }

    @Override
    public void delete(int id){
        articleDAO.delete(id);
    }

    public void saveOrUpdate(Article entity){
        articleDAO.saveOrUpdate(entity);
    }
}
