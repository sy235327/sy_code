package com.demo.regist_action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 属性驱动
 */
public class Regist1Action extends ActionSupport{
    //属性驱动方式 第一种在action中提供set方法,框架过滤器会通过映射将参数封装进action中
    private String username;
    private String password;
    private Integer age;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String execute() throws Exception{
        System.out.println(username+" "+password+"  "+age);
        return NONE;
    }
}
