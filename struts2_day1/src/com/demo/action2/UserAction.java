package com.demo.action2;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 动态方法访问方式
 * 需要在配置中开启一个常量
 * 在struts.xml中配置
 * <constant name="struts.enable.DynamicMethodInvocation" value="true" />
 */
public class UserAction extends ActionSupport {

    private static final long serialVersionUID = 2326886457881070180L;

    //保存用户
    public String save(){
        System.out.println("保存用户");
        return NONE;
    }

    //删除用户
    public String delete(){
        System.out.println("删除用户...");
        return NONE;
    }
}
