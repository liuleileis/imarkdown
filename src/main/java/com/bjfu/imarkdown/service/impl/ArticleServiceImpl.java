package com.bjfu.imarkdown.service.impl;

import com.bjfu.imarkdown.domain.Article;
import com.bjfu.imarkdown.repository.ArticleDao;
import com.bjfu.imarkdown.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Override
    public List<Article> findAll() {
        return articleDao.findAllArticle();
    }

    @Override
    public List<Article> findAllPage(Integer page, Integer limit){
        int start = (page - 1) * limit;
        return articleDao.findAllArticlePage(start, limit);
    }

    @Override
    public List<Article> findByTitle(String articleTitle) {
        return articleDao.findArticleByTitle(articleTitle);
    }

    @Override
    public List<Article> findById(Integer articleId){
        return articleDao.findArticleById(articleId);
    }

    @Override
    public void update(Article article) {
        articleDao.updateArticle(article.getArticleTitle(), article.getArticleContent(),
                article.getArticleHtml(), article.getArticleAuthor(),
                article.getArticleTime(), article.getArticleId());
    }

    @Override
    public void delete(Integer articleId) {
        articleDao.deleteArticle(articleId);
    }

    @Override
    public void insert(Article article) {
        articleDao.insertArticle(article.getArticleTitle(),
                article.getArticleContent(),
                article.getArticleHtml(),
                article.getArticleAuthor(),
                article.getArticleTime());
    }
}
