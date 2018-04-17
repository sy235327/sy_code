package com.demo.regist_action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 属性驱动方式,把数据封装到javabean的对象中
 */
public class Regist2Action extends ActionSupport {
    //注意二: 属性驱动的方式,需要提供get和set方法
    private User user;

    public User getUser() {
        System.out.println("getUser-------");
        return user;
    }

    public void setUser(User user) {
        System.out.println("setUser-------");
        this.user = user;
    }

    @Override
    public String execute(){
        System.out.println(user);
        return NONE;
    }
}
