package com.example.bean;

public class Address
{
    private String wxId;
    private String address;

    public Address()
    {
    }

    public Address(String wxId, String address)
    {
        this.wxId = wxId;
        this.address = address;
    }

    @Override
    public String toString()
    {
        return "Address{" +
                "wxId='" + wxId + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public String getWxId()
    {
        return wxId;
    }

    public void setWxId(String wxId)
    {
        this.wxId = wxId;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }
}
