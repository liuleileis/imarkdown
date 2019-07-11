package com.bjfu.imarkdown.domain;


import java.sql.Timestamp;

public class Article {
    private int articleId;
    private String articleTitle;
    private String articleContent;
    private String articleHtml;
    private String articleAuthor;
    private Timestamp articleTime;

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public String getArticleHtml() {
        return articleHtml;
    }

    public void setArticleHtml(String articleHtml) {
        this.articleHtml = articleHtml;
    }

    public String getArticleAuthor() {
        return articleAuthor;
    }

    public void setArticleAuthor(String articleAuthor) {
        this.articleAuthor = articleAuthor;
    }

    public Timestamp getArticleTime() {
        return articleTime;
    }

    public void setArticleTime(Timestamp articleTime) {
        this.articleTime = articleTime;
    }
}
