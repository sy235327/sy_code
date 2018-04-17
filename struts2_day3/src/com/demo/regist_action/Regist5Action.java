package com.demo.regist_action;

import com.opensymphony.xwork2.ActionSupport;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 属性驱动方式,把数据封装到Map集合中
 * 将数据封装到对象中,再将对象封装到集合中
 */
public class Regist5Action extends ActionSupport{
    //在action中写一个map集合的属性,提供get和set方法
    private Map<String,User> map;

    public Map<String, User> getMap() {
        return map;
    }

    public void setMap(Map<String, User> map) {
        this.map = map;
    }

    @Override
    public String execute(){
        System.out.println(map);
        return NONE;
    }
}
