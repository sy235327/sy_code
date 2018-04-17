package com.demo.domain;

/**
 * javabean 商品分类
 */
public class Category {
    private String cid;
    private String cname;

    public Category() {
    }

    public Category(String cid, String cname) {
        this.cid = cid;
        this.cname = cname;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCid() {
        return cid;
    }

    public String getCname() {
        return cname;
    }
}
