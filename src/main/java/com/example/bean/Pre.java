package com.example.bean;

public class Pre
{
    private Integer id;
    private Integer shangwu1;
    private Integer shangwu2;
    private Integer xiawu1;
    private Integer xiawu2;

    public Pre(Integer id, Integer shangwu1, Integer shangwu2, Integer xiawu1, Integer xiawu2)
    {
        this.id = id;
        this.shangwu1 = shangwu1;
        this.shangwu2 = shangwu2;
        this.xiawu1 = xiawu1;
        this.xiawu2 = xiawu2;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getShangwu1()
    {
        return shangwu1;
    }

    public void setShangwu1(Integer shangwu1)
    {
        this.shangwu1 = shangwu1;
    }

    public Integer getShangwu2()
    {
        return shangwu2;
    }

    public void setShangwu2(Integer shangwu2)
    {
        this.shangwu2 = shangwu2;
    }

    public Integer getXiawu1()
    {
        return xiawu1;
    }

    public void setXiawu1(Integer xiawu1)
    {
        this.xiawu1 = xiawu1;
    }

    public Integer getXiawu2()
    {
        return xiawu2;
    }

    public void setXiawu2(Integer xiawu2)
    {
        this.xiawu2 = xiawu2;
    }
}
