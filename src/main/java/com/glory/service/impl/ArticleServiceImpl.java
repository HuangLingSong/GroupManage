package com.glory.service.impl;

import com.glory.entity.Article;
import com.glory.dao.ArticleDAO;
import com.glory.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by XRom
 * On 11/16/2017.11:58 PM
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired(required = true)
    private ArticleDAO articleDAO;

    @Override
    public Long saveArticle() {
        Article article = new Article();
        article.setTitle("黄凌淞");
        article.setContent("18408287865");
        article.setUser_id(1);
        article.setRole_id(1);
        return articleDAO.save(article);
    }
}
