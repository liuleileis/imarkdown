package com.bjfu.imarkdown.service;

import com.bjfu.imarkdown.domain.Article;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ArticleService {
    List<Article> findAll();

    List<Article> findById(Integer articleId);

    List<Article> findByTitle(String articleTitle);

    List<Article> findAllPage (Integer page, Integer limit);

    void update(Article article);

    void delete(Integer articleId);

    void insert(Article article);
}
