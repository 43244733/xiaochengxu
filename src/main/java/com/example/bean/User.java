package com.example.bean;

public class User
{
    private Integer id;
    private String name;        // 账号
    private String password;    // 密码
    private String url;         // 头像路径

    public User()
    {
    }

    public User(String name, String password)
    {
        this.name = name;
        this.password = password;
    }

    public User(Integer id, String name, String password, String url)
    {
        this.id = id;
        this.name = name;
        this.password = password;
        this.url = url;
    }

    @Override
    public String toString()
    {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", url='" + url + '\'' +
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

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }
}
