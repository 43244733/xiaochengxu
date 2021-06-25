package com.example.bean;

public class View
{
    private Integer id;
    private Integer aId;
    private String wxId;
    private String look;

    public View(Integer id, Integer aId, String wxId, String look)
    {
        this.id = id;
        this.aId = aId;
        this.wxId = wxId;
        this.look = look;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getaId()
    {
        return aId;
    }

    public void setaId(Integer aId)
    {
        this.aId = aId;
    }

    public String getWxId()
    {
        return wxId;
    }

    public void setWxId(String wxId)
    {
        this.wxId = wxId;
    }

    public String getLook()
    {
        return look;
    }

    public void setLook(String look)
    {
        this.look = look;
    }
}
