package com.example.bean;

public class WxPayer {

    private Integer app_id;
    private String trade_no;
    private String in_trade_no;
    private String out_trade_no;
    private String trade_type;
    private String description;
    private String pay_type;
    private String amount;
    private Integer attach;
    private String create_time;
    private String pay_time;
    private Integer notify_count;
    private String sign;

    public WxPayer(Integer app_id, String trade_no, String in_trade_no, String out_trade_no, String trade_type, String description, String pay_type, String amount, Integer attach, String create_time, String pay_time, Integer notify_count, String sign) {
        this.app_id = app_id;
        this.trade_no = trade_no;
        this.in_trade_no = in_trade_no;
        this.out_trade_no = out_trade_no;
        this.trade_type = trade_type;
        this.description = description;
        this.pay_type = pay_type;
        this.amount = amount;
        this.attach = attach;
        this.create_time = create_time;
        this.pay_time = pay_time;
        this.notify_count = notify_count;
        this.sign = sign;
    }

    public Integer getApp_id() {
        return app_id;
    }

    public void setApp_id(Integer app_id) {
        this.app_id = app_id;
    }

    public String getTrade_no() {
        return trade_no;
    }

    public void setTrade_no(String trade_no) {
        this.trade_no = trade_no;
    }

    public String getIn_trade_no() {
        return in_trade_no;
    }

    public void setIn_trade_no(String in_trade_no) {
        this.in_trade_no = in_trade_no;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getTrade_type() {
        return trade_type;
    }

    public void setTrade_type(String trade_type) {
        this.trade_type = trade_type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPay_type() {
        return pay_type;
    }

    public void setPay_type(String pay_type) {
        this.pay_type = pay_type;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Integer getAttach() {
        return attach;
    }

    public void setAttach(Integer attach) {
        this.attach = attach;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getPay_time() {
        return pay_time;
    }

    public void setPay_time(String pay_time) {
        this.pay_time = pay_time;
    }

    public Integer getNotify_count() {
        return notify_count;
    }

    public void setNotify_count(Integer notify_count) {
        this.notify_count = notify_count;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    @Override
    public String toString() {
        return "WxPayer{" +
                "app_id=" + app_id +
                ", trade_no='" + trade_no + '\'' +
                ", in_trade_no='" + in_trade_no + '\'' +
                ", out_trade_no='" + out_trade_no + '\'' +
                ", trade_type='" + trade_type + '\'' +
                ", description='" + description + '\'' +
                ", pay_type='" + pay_type + '\'' +
                ", amount='" + amount + '\'' +
                ", attach=" + attach +
                ", create_time='" + create_time + '\'' +
                ", pay_time='" + pay_time + '\'' +
                ", notify_count=" + notify_count +
                ", sign='" + sign + '\'' +
                '}';
    }
}
