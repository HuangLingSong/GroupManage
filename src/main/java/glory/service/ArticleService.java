package glory.service;

import java.util.List;

import glory.entity.Article;
import glory.util.PageBean;

public interface ArticleService {

	List<Article> findAll();

	Article getArticleById(int id);

	void updateArticle(Article article);

	void saveArticle(Article article);

	void deleteArticle(Article article);


}
