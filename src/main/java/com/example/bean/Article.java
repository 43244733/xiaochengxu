package com.example.bean;


public class Article
{
    private Integer id;
    private String title;       // 标题
    private String author;      // 作者
    private String brief;       // 简介
    private String content;     // 内容
    private String type;        // 类型
    private String time;        // 发布时间
    private Integer num;        // 阅读量

    public Article()
    {
    }

    public Article(Integer id, String title) {
        this.id = id;
        this.title = title;
    }

    public Article(String title, String content)
    {
        this.title = title;
        this.content = content;
    }

    public Article(Integer id, String title, String type) {
        this.id = id;
        this.title = title;
        this.type = type;
    }

    public Article(Integer id, String title, String content, String type, String time, Integer num)
    {
        this.id = id;
        this.title = title;
        this.content = content;
        this.type = type;
        this.time = time;
        this.num = num;
    }

    public Article(Integer id, String title, String author, String brief, String content, String type, String time)
    {
        this.id = id;
        this.title = title;
        this.author = author;
        this.brief = brief;
        this.content = content;
        this.type = type;
        this.time = time;
    }

    @Override
    public String toString()
    {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", brief='" + brief + '\'' +
                ", content='" + content + '\'' +
                ", type='" + type + '\'' +
                ", time='" + time + '\'' +
                ", num=" + num +
                '}';
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public String getBrief()
    {
        return brief;
    }

    public void setBrief(String brief)
    {
        this.brief = brief;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getTime()
    {
        return time;
    }

    public void setTime(String time)
    {
        this.time = time;
    }

    public Integer getNum()
    {
        return num;
    }

    public void setNum(Integer num)
    {
        this.num = num;
    }
}
