package com.bjfu.imarkdown.controller;

import com.bjfu.imarkdown.domain.Article;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class IMarkdownController {
    @RequestMapping(value = "/")
    public String showIMarkdown(Map map){
//        map.put("article", new Article());
//        ModelAndView modelAndView = new ModelAndView("index.html", map);
        return "index";
    }
    @RequestMapping(value = "/to-article-list")
    public String toArticleList(){
        return "article-list";
    }
}
