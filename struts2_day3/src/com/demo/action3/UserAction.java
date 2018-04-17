package com.demo.action3;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 测试自定义拦截器
 */
public class UserAction extends ActionSupport {
    @Override
    public String execute() throws Exception {
        System.out.println("Action执行-------");
        return NONE;
    }
}
