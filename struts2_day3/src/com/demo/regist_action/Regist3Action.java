package com.demo.regist_action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 模型驱动
 * 实现ModelDriven接口
 * 必须要手动实例化对象(需要自己new对象)
 */
public class Regist3Action extends ActionSupport implements ModelDriven<User>{
    //必须要手动实例化对象
    private User user = new User();

    //获取模型对象
    @Override
    public User getModel() {
        return user;
    }

    @Override
    public String execute(){
        System.out.println(user);
        return NONE;
    }
}
