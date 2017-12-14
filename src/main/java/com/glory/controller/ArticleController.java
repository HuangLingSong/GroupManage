package com.glory.controller;


import com.glory.entity.Article;
import com.glory.entity.ResponseJson;
import com.glory.entity.User;
import com.glory.service.ArticleService;
import org.hibernate.cache.spi.QueryResultsRegion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("Article")
public class ArticleController {

    @Autowired(required = true)
    private ArticleService articleService;

    @RequestMapping(value = "List",method = RequestMethod.GET)
    public String list(HttpServletRequest request){
        List<Article> articles =  articleService.findAll();

        if (articles !=null){
            request.setAttribute("articles", articles);
        }
        return "article/list";
    }

    @RequestMapping(value = "Create",method = RequestMethod.GET)
    public String create(){
        return "article/handler";
    }

    @RequestMapping(value = "Edit",method = RequestMethod.GET)
    public String edit(HttpServletRequest request,@RequestParam("id") int id){
        Article  article= articleService.get(id);
        if (article !=null){
            request.setAttribute("article", article);
        }
        return "article/handler";
    }

    @RequestMapping(value = "EditForm",method = RequestMethod.POST)
    public String edit(HttpServletRequest request,@RequestParam("id") int id,@RequestParam("title") String title, @RequestParam("content") String content){
        Article  article= articleService.get(id);
        article.setTitle(title);
        article.setContent(content);
        articleService.saveOrUpdate(article);
        return "article/handler?id="+id;
    }

    @RequestMapping(value = "Details",method = RequestMethod.GET)
    public String showDetails(HttpServletRequest request,@RequestParam("id") int id){
        Article  article= articleService.get(id);
        if (article !=null){
            request.setAttribute("article", article);
        }
        return "article/details";
    }

    @RequestMapping(value = "CreateForm",method = RequestMethod.POST)
    @ResponseBody
    public ResponseJson createForm(@RequestParam("title") String title, @RequestParam("content") String content,HttpSession httpSession){
        ResponseJson responseJson;
        User user= (User) httpSession.getAttribute("User");
        Article article = new Article();
        article.setTitle(title);
        article.setContent(content);
        article.setarticleByUser(user);
        int status = articleService.save(article);
        System.out.println(status);
        if (status != 0) {

            responseJson = new ResponseJson(0, null, "新添成功");

        } else {
            responseJson = new ResponseJson(104, null, "新添失败");
        }

        return responseJson;
    }

    @RequestMapping(value = "DeleteForm",method = RequestMethod.POST)
    @ResponseBody
    public ResponseJson deleteForm(@RequestParam("id") int id){
        ResponseJson responseJson;

         articleService.delete(id);

         responseJson = new ResponseJson(0, null, "删除成功");

        return responseJson;
    }
}
