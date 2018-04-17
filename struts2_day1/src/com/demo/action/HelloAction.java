package com.demo.action;

/**
 * struts2框架都使用action类处理用户请求
 */
public class HelloAction{
    /**
     * Action类中方法定义有要求
     *
     * public 共有的
     * 必须有返回值,必须是String类型
     * 方法名称可以是任意,但是不能带参数列表
     *
     * 页面的跳转: 配置
     *  1.return 要转发的页面
     *  2.需要在struts.xml配置文件中,配置跳转的页面
     */
    public String sayHello(){
        //编写代码 接收请求的参数
        System.out.println("Hello Struts2");
        return "ok";
    }

    /**
     * 演示的配置文件中method属性的默认值(method属性默认值就是execute)
     * @return
     */
    public String execute(){
        System.out.println("method的方法默认值是execute");
        return null;
    }
}
