package com.example.bean;

public class Illness
{
    private Integer id;
    private String department;
    private String month;
    private String day;
    private String type;
    private String wxId;

    public Illness(Integer id, String department, String month, String day, String type, String wxId)
    {
        this.id = id;
        this.department = department;
        this.month = month;
        this.day = day;
        this.type = type;
        this.wxId = wxId;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getDepartment()
    {
        return department;
    }

    public void setDepartment(String department)
    {
        this.department = department;
    }

    public String getMonth()
    {
        return month;
    }

    public void setMonth(String month)
    {
        this.month = month;
    }

    public String getDay()
    {
        return day;
    }

    public void setDay(String day)
    {
        this.day = day;
    }

    public String getWxId()
    {
        return wxId;
    }

    public void setWxId(String wxId)
    {
        this.wxId = wxId;
    }
}
