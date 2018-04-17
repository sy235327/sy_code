package com.demo.domain;

import java.util.List;

/**
 * javabean, 封装product和分页的数据
 */
public class PageBean<T> {
    //当前页面
    private int currentPage;

    //当前页显示商品个数
    private int currentCount;

    //总商品个数
    private int totalCount;

    //总页数
    private int totalPage;

    //当前页面商品信息
    private List<T> list;

    public int getCurrentPage() {
        return currentPage;
    }

    public int getCurrentCount() {
        return currentCount;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public void setCurrentCount(int currentCount) {
        this.currentCount = currentCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
