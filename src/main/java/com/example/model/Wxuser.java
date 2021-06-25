package com.example.model;

import java.util.Date;

public class Wxuser
{
    private Integer wxid;

    private String nickname;

    private String wxopenid;

    private Date registertime;

    private Integer gender;

    private String province;

    private String city;

    private String country;

    private String iconstr;

    public Integer getWxid()
    {
        return wxid;
    }

    public void setWxid(Integer wxid)
    {
        this.wxid = wxid;
    }

    public String getNickname()
    {
        return nickname;
    }

    public void setNickname(String nickname)
    {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getWxopenid()
    {
        return wxopenid;
    }

    public void setWxopenid(String wxopenid)
    {
        this.wxopenid = wxopenid == null ? null : wxopenid.trim();
    }

    public Date getRegistertime()
    {
        return registertime;
    }

    public void setRegistertime(Date registertime)
    {
        this.registertime = registertime;
    }

    public Integer getGender()
    {
        return gender;
    }

    public void setGender(Integer gender)
    {
        this.gender = gender;
    }

    public String getProvince()
    {
        return province;
    }

    public void setProvince(String province)
    {
        this.province = province == null ? null : province.trim();
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city == null ? null : city.trim();
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country == null ? null : country.trim();
    }

    public String getIconstr()
    {
        return iconstr;
    }

    public void setIconstr(String iconstr)
    {
        this.iconstr = iconstr == null ? null : iconstr.trim();
    }
}