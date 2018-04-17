package com.demo.action2;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 编写的客户的Action的类
 * 传统方式配置action
 */
public class CustomerAction extends ActionSupport{

    private static final long serialVersionUID = 3325771460772512614L;

    //保存客户
    public String save(){
        System.out.println("保存客户");
        return NONE;
    }

    //删除客户
    public String delete(){
        System.out.println("删除客户...");
        return NONE;
    }
}
