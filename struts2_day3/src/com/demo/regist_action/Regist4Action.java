package com.demo.regist_action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.util.Arrays;
import java.util.List;

/**
 * 属性驱动方式,把数据封装到List集合中
 * 将数据封装到对象中,再将对象封装到集合中
 */
public class Regist4Action extends ActionSupport{
    //创建一个List集合 提供get和set方法
    private List<User> list;

    public List<User> getList() {
        return list;
    }

    public void setList(List<User> list) {
        this.list = list;
    }

    @Override
    public String execute(){
        System.out.println(Arrays.toString(list.toArray()));
        return NONE;
    }
}
