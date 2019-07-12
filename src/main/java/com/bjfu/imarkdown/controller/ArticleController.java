package com.bjfu.imarkdown.controller;

import com.alibaba.fastjson.JSONObject;
import com.bjfu.imarkdown.domain.Article;
import com.bjfu.imarkdown.domain.Result;
import com.bjfu.imarkdown.service.ArticleService;
import com.bjfu.imarkdown.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/imarkdown")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping(value = "/insert")
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

    @PostMapping("/edit-do")
    @ResponseBody
    public Result editArticle(Article article){
        articleService.update(article);
        return ResultUtil.success();
    }

    @RequestMapping("/edit/{articleId}")
    public ModelAndView toEditArticle(@PathVariable(value = "articleId") int articleId, Map map){
        List<Article> articles = articleService.findById(articleId);
        if(articles != null && !articles.isEmpty())
            map.put("article", articles.get(0));
        else
            map.put("article", new Article());
        return new ModelAndView("editArticle", map);
    }

    @RequestMapping("/show-all")
    @ResponseBody
    public JSONObject showAllArticle(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "limit", required = false) Integer limit){
        List<Article> ans = null;
        List<Article> list = articleService.findAll();
        int count = list.size();
        if(null != page && null != limit && page > 0 && limit > 0){
            ans = articleService.findAllPage(page, limit);
        }else{
            ans = list;
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("count", count);
        jsonObject.put("code", 0);
        jsonObject.put("msg", "查询成功");
        jsonObject.put("data", ans);
        return jsonObject;
    }
}
