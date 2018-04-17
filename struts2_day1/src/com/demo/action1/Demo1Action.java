package com.demo.action1;

/**
 * PoJO类: 没有任何的继承和实现
 */
public class Demo1Action {
    /**
     * execute是默认方法
     * @return null; 页面不进行跳转
     */
    public String execute(){
        System.out.println("Demo1Action是一个POJO类");
        return null;
    }
}
