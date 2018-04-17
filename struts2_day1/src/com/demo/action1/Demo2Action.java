package com.demo.action1;


import com.opensymphony.xwork2.Action;

/**
 * 实现Action的接口,Action是框架提供的接口
 */
public class Demo2Action implements Action {
    @Override
    public String execute() throws Exception {
        System.out.println("Demo2Action实现了Action接口");

        //和return "success",这些常量可以去action里面值 根据值写配置中的result标签的配置
        //return SUCCESS;

        //表示页面不跳转,(即使在result标签中配置了,但是也不会跳转)
        return NONE;
    }
}
