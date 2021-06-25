package com.example.bean;

public class Shop
{
    private Integer id;
    private String name;            // 商品名称
    private Double price;           // 商品价格
    private String type;            // 类别
    private String time;            // 商品上架时间
    private String description;     // 描述
    private String url;             // 图片地址
    private Integer number;         // 库存数量
    private Integer uId;            // 商家

    public Shop()
    {
    }

    public Shop(Integer id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public Shop(Integer id, String name, Double price, String type, String time, String description, String url, Integer number, Integer uId)
    {
        this.id = id;
        this.name = name;
        this.price = price;
        this.type = type;
        this.time = time;
        this.description = description;
        this.url = url;
        this.number = number;
        this.uId = uId;
    }

    @Override
    public String toString()
    {
        return "Shop{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", time='" + time + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", number=" + number +
                ", uId=" + uId +
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

    public Double getPrice()
    {
        return price;
    }

    public void setPrice(Double price)
    {
        this.price = price;
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

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public Integer getNumber()
    {
        return number;
    }

    public void setNumber(Integer number)
    {
        this.number = number;
    }

    public Integer getuId()
    {
        return uId;
    }

    public void setuId(Integer uId)
    {
        this.uId = uId;
    }
}
