package com.example.bean;

public class Anonymous
{
    private Integer id;
    private String content;
    private String url;
    private Integer qushi;
    private Integer tongzhi;
    private Integer biaobai;
    private Integer xunwuqishi;
    private String wxId;
    private Integer time;

    public Anonymous()
    {
    }

    public Anonymous(Integer id, String content, Integer qushi, Integer tongzhi, Integer biaobai, Integer xunwuqishi, String wxId, Integer time)
    {
        this.id = id;
        this.content = content;
        this.qushi = qushi;
        this.tongzhi = tongzhi;
        this.biaobai = biaobai;
        this.xunwuqishi = xunwuqishi;
        this.wxId = wxId;
        this.time = time;
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

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public Integer getQushi()
    {
        return qushi;
    }

    public void setQushi(Integer qushi)
    {
        this.qushi = qushi;
    }

    public Integer getTongzhi()
    {
        return tongzhi;
    }

    public void setTongzhi(Integer tongzhi)
    {
        this.tongzhi = tongzhi;
    }

    public Integer getBiaobai()
    {
        return biaobai;
    }

    public void setBiaobai(Integer biaobai)
    {
        this.biaobai = biaobai;
    }

    public Integer getXunwuqishi()
    {
        return xunwuqishi;
    }

    public void setXunwuqishi(Integer xunwuqishi)
    {
        this.xunwuqishi = xunwuqishi;
    }

    public String getWxId()
    {
        return wxId;
    }

    public void setWxId(String wxId)
    {
        this.wxId = wxId;
    }

    public Integer getTime()
    {
        return time;
    }

    public void setTime(Integer time)
    {
        this.time = time;
    }
}
