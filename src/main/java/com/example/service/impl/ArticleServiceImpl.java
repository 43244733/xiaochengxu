package com.example.service.impl;

import com.example.bean.Article;
import com.example.bean.View;
import com.example.mapper.ArticleMapper;
import com.example.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService
{
    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public void insertArticle(Article article)
    {
        articleMapper.insertArticle(article);
    }

    @Override
    public List<Article> selectAllArticle()
    {
        return articleMapper.selectAllArticle();
    }

    @Override
    public List<Article> selectAllArticleIdAndTitle() {
        return articleMapper.selectAllArticleIdAndTitle();
    }

    @Override
    public int selectArticleCount()
    {
        return articleMapper.selectArticleCount();
    }

    @Override
    public void deleteArticle(Integer id)
    {
        articleMapper.deleteArticle(id);
    }

    @Override
    public Article selectArticleById(Integer id)
    {
        return articleMapper.selectArticleById(id);
    }

    @Override
    public void updateArticle(Article article)
    {
        articleMapper.updateArticle(article);
    }

    @Override
    public void updateNum(Integer id, Integer num)
    {
        articleMapper.updateNum(id, num);
    }

    @Override
    public void insertView(Integer aId, String wxId)
    {
        articleMapper.insertView(aId, wxId);
    }

    @Override
    public List<View> selectAllView(String wxId)
    {
        return articleMapper.selectAllView(wxId);
    }

    @Override
    public String selectViewById(Integer aId, String wxId)
    {
        return articleMapper.selectViewById(aId, wxId);
    }

    /**
     * 查询谋篇文章的阅读量
     * @param aid
     */
    @Override
    public Integer selectArticleNumByAId(Integer aid) {
        return articleMapper.selectArticleNumByAId(aid);
    }
}
