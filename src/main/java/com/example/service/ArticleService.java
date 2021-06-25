package com.example.service;

import com.example.bean.Article;
import com.example.bean.View;

import java.util.List;

public interface ArticleService
{
    // 添加文章
    void insertArticle(Article article);

    // 查询全部文章
    List<Article> selectAllArticle();

    // 查询文章ID和题目
    List<Article> selectAllArticleIdAndTitle();

    // 文章数量
    int selectArticleCount();

    // 删除文章
    void deleteArticle(Integer id);

    // 通过id查询文章
    Article selectArticleById(Integer id);

    // 修改
    void updateArticle(Article article);

    void updateNum(Integer id, Integer num);

    void insertView(Integer aId, String wxId);

    List<View> selectAllView(String wxId);

    /**
     * 查看该用户是否阅读过本文章
     */
    String selectViewById(Integer aId, String wxId);

    /**
     * 查询谋篇文章的阅读量
     */
    Integer selectArticleNumByAId(Integer aid);
}
