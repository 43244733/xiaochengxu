package com.example.bean;

public class Message
{
    private Integer id;
    private String content;
    private String wxuName;
    private String wxId;
    private Integer gId;

    public Message()
    {
    }

    public Message(String content, String wxuName, Integer gId)
    {
        this.content = content;
        this.wxuName = wxuName;
        this.gId = gId;
    }

    public Message(Integer id, String content, String wxuName, Integer gId)
    {
        this.id = id;
        this.content = content;
        this.wxuName = wxuName;
        this.gId = gId;
    }

    public Message(Integer id, String content, String wxuName, String wxId, Integer gId)
    {
        this.id = id;
        this.content = content;
        this.wxuName = wxuName;
        this.wxId = wxId;
        this.gId = gId;
    }

    @Override
    public String toString()
    {
        return "Message{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", wxuName='" + wxuName + '\'' +
                ", wxId='" + wxId + '\'' +
                ", gId=" + gId +
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

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public String getWxuName()
    {
        return wxuName;
    }

    public void setWxuName(String wxuName)
    {
        this.wxuName = wxuName;
    }

    public String getWxId()
    {
        return wxId;
    }

    public void setWxId(String wxId)
    {
        this.wxId = wxId;
    }

    public Integer getgId()
    {
        return gId;
    }

    public void setgId(Integer gId)
    {
        this.gId = gId;
    }
}
