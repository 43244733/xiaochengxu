package com.example.bean;

public class ShoppingCart
{
    private Integer id;
    private Integer gId;
    private String wxId;
    private Integer type;

    public ShoppingCart()
    {
    }

    public ShoppingCart(Integer gId, String wxId)
    {
        this.gId = gId;
        this.wxId = wxId;
    }

    public ShoppingCart(Integer id, Integer gId, String wxId, Integer type)
    {
        this.id = id;
        this.gId = gId;
        this.wxId = wxId;
        this.type = type;
    }

    @Override
    public String toString()
    {
        return "ShoppingCart{" +
                "id=" + id +
                ", gId=" + gId +
                ", wxId='" + wxId + '\'' +
                ", type=" + type +
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

    public Integer getgId()
    {
        return gId;
    }

    public void setgId(Integer gId)
    {
        this.gId = gId;
    }

    public String getWxId()
    {
        return wxId;
    }

    public void setWxId(String wxId)
    {
        this.wxId = wxId;
    }

    public Integer getType()
    {
        return type;
    }

    public void setType(Integer type)
    {
        this.type = type;
    }
}
