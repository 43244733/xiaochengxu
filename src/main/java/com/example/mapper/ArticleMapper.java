package com.example.mapper;

import com.example.bean.Article;
import com.example.bean.View;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleMapper
{
    void insertArticle(Article article);

    List<Article> selectAllArticle();

    int selectArticleCount();

    void deleteArticle(Integer id);

    Article selectArticleById(Integer id);

    void updateArticle(Article article);

    void updateNum(@Param("id") Integer id, @Param("num") Integer num);

    void insertView(Integer aId, String wxId);

    List<View> selectAllView(String wxId);

    String selectViewById(Integer aId, String wxId);

    Integer selectArticleNumByAId(Integer aid);

    // 查询文章ID和题目
    List<Article> selectAllArticleIdAndTitle();
}
