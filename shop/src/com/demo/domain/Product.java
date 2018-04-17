package com.demo.domain;

import java.util.Date;

/**
 * javabean 存储商品
 */
public class Product {
    private String pid;
    private String pname;
    private double market_price;
    private double shop_price;
    private String pimage;
    private Date pdate;
    private int is_hot;
    private String pdesc;
    private int pflag;
    private Category category;//从表的外键,值对应主表的主键. 使用对象区分

    public Product() {
    }

    public Product(String pid, String pname, double market_price, double shop_price, String pimage, Date pdate, int is_hot, String pdesc, int pflag, Category category) {
        this.pid = pid;
        this.pname = pname;
        this.market_price = market_price;
        this.shop_price = shop_price;
        this.pimage = pimage;
        this.pdate = pdate;
        this.is_hot = is_hot;
        this.pdesc = pdesc;
        this.pflag = pflag;
        this.category = category;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public void setMarket_price(double market_price) {
        this.market_price = market_price;
    }

    public void setShop_price(double shop_price) {
        this.shop_price = shop_price;
    }

    public void setPimage(String pimage) {
        this.pimage = pimage;
    }

    public void setPdate(Date pdate) {
        this.pdate = pdate;
    }

    public void setIs_hot(int is_hot) {
        this.is_hot = is_hot;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc;
    }

    public void setPflag(int pflag) {
        this.pflag = pflag;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getPid() {
        return pid;
    }

    public String getPname() {
        return pname;
    }

    public double getMarket_price() {
        return market_price;
    }

    public double getShop_price() {
        return shop_price;
    }

    public String getPimage() {
        return pimage;
    }

    public Date getPdate() {
        return pdate;
    }

    public int getIs_hot() {
        return is_hot;
    }

    public String getPdesc() {
        return pdesc;
    }

    public int getPflag() {
        return pflag;
    }

    public Category getCategory() {
        return category;
    }
}
