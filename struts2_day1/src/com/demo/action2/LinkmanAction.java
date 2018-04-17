package com.demo.action2;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 编写联系人的action
 * 通配符的方式配置action
 */
public class LinkmanAction extends ActionSupport{

    private static final long serialVersionUID = 3325771460772512614L;

    //保存联系人
    public String save(){
        System.out.println("保存联系人");
        return NONE;
    }

    //删除联系人
    public String delete(){
        System.out.println("删除联系人...");
        return NONE;
    }


}
