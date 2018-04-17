package com.demo.user_action1;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/**
 * 完全解耦合的方式,使用Servlet的API
 */
public class Demo1Action extends ActionSupport{
    @Override
    public String execute() throws Exception {
        //完全解耦合的方式
        ActionContext actionContext = ActionContext.getContext();
        //获取到请求的参数,封装所有的请求的参数
        Map<String, Object> map = actionContext.getParameters();

        //遍历获取的数据
        Set<String> keys = map.keySet();
        for (String key : keys){
            String[] vals = (String[]) map.get(key);
            System.out.println(key+"  "+ Arrays.toString(vals));
        }

        //向request对象中存入值
        actionContext.put("msg","大桥未久");

        //获取其他的map集合
        //向session域对象中存储
        actionContext.getSession().put("msg","苍老师");

        //向全局域对象中存储
        actionContext.getApplication().put("msg","小泽玛利亚");

        return SUCCESS;
    }
}
