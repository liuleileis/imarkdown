package com.bjfu.imarkdown.controller;

import com.bjfu.imarkdown.domain.Article;
import com.bjfu.imarkdown.domain.Result;
import com.bjfu.imarkdown.service.ArticleService;
import com.bjfu.imarkdown.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/imarkdown")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping
    @ResponseBody
    public Result saveArticle(Article article){
        articleService.insert(article);
        return ResultUtil.success();
    }

    @RequestMapping("/show/{articleId}")
    public ModelAndView showArticle(@PathVariable(value = "articleId") int articleId, Map map){
        List<Article> articles = articleService.findById(articleId);
        if(articles != null && !articles.isEmpty())
            map.put("article", articles.get(0));
        else
            map.put("article", new Article());
        return new ModelAndView("article", map);
    }

    @RequestMapping("/show-all")
    public List<Article> showAllArticle(){
        return articleService.findAll();
    }
}
