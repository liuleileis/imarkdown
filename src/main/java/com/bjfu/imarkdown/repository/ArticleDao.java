package com.bjfu.imarkdown.repository;

import com.bjfu.imarkdown.domain.Article;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Mapper
@Repository
public interface ArticleDao {
    @Select("SELECT * FROM article WHERE article_tile = #{articleTitle}")
    List<Article> findArticleByTitle(@Param("articleTitle") String articleTitle);

    @Select("SELECT * FROM article WHERE article_id = #{articleId}")
    List<Article> findArticleById(@Param("articleId") Integer articleId);

    @Select("SELECT * FROM article")
    List<Article> findAllArticle();

    @Select("SELECT * FROM article LIMIT #{start},#{limit}")
    List<Article> findAllArticlePage(@Param("start") Integer start, @Param("limit") Integer limit);

    @Insert({"INSERT INTO " +
            "article(article_title, article_content, article_html, article_author, article_time) " +
            "VALUES(#{articleTitle}, #{articleContent}, #{articleHtml}, #{articleAuthor}, #{articleTime})"})
    void insertArticle(@Param("articleTitle") String articleTitle, @Param("articleContent") String articleContent, @Param("articleHtml") String articleHtml,
                       @Param("articleAuthor") String articleAuthor, @Param("articleTime") Timestamp articleTime);

    @Delete("DELETE from article WHERE article_id = #{articleId}")
    void deleteArticle(@Param("articleId") Integer articleId);

    @Update("UPDATE  article " +
            "SET " +
            "article_title = #{articleTitle}," +
            "article_content = #{articleContent}," +
            "article_html = #{articleHtml}," +
            "article_author = #{articleAuthor}," +
            "article_time = #{articleTime} " +
            "WHERE" +
            "article_id = #{articleId}")
    void updateArticle(@Param("articleTitle") String articleTitle, @Param("articleContent") String articleContent, @Param("articleHtml") String articleHtml,
                       @Param("articleAuthor") String articleAuthor, @Param("articlTime") Timestamp articlTime, @Param("articleId") Integer articleId);
}
