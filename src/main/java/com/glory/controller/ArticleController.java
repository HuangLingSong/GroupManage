package com.glory.controller;


import com.glory.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("Article")
public class ArticleController {

    @Autowired(required = true)
    private ArticleService articleService;

    @RequestMapping(value = "List",method = RequestMethod.GET)
    public String list(HttpServletRequest request){

        return "article/list";
    }

    @RequestMapping(value = "Create",method = RequestMethod.GET)
    public String create(HttpServletRequest request){
        articleService.saveArticle();
        return "article/create";
    }
}
