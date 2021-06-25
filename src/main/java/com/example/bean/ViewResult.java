package com.example.bean;

import java.util.List;

public class ViewResult
{
    private List<Article> articleList;
    private List<View> viewList;

    public ViewResult(List<Article> articleList, List<View> viewList)
    {
        this.articleList = articleList;
        this.viewList = viewList;
    }

    public List<View> getViewList()
    {
        return viewList;
    }

    public void setViewList(List<View> viewList)
    {
        this.viewList = viewList;
    }

    public List<Article> getArticleList()
    {
        return articleList;
    }

    public void setArticleList(List<Article> articleList)
    {
        this.articleList = articleList;
    }
}
