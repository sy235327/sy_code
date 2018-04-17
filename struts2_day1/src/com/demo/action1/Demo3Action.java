package com.demo.action1;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 编写Action类继承ActionSupport类,ActionSupport类已经实现了Action和一些其他的接口(开发常用)
 */
public class Demo3Action extends ActionSupport{
    //可以不生成
    private static final long serialVersionUID = -1105694420986578196L;

    @Override
    public String execute() throws Exception {
        System.out.println("Demo3Action继承了ActionSupport类");
        return NONE;
    }
}
