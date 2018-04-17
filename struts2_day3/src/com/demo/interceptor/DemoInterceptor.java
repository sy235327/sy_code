package com.demo.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 自定一个简单的拦截器
 */
public class DemoInterceptor extends AbstractInterceptor{

    /**
     * intercept用来进行拦截的
     * @param actionInvocation
     * @return
     * @throws Exception
     */
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        System.out.println("Action方法执行之前...");
        //执行下一个拦截器
        String invoke = actionInvocation.invoke();

        System.out.println("Action方法执行之后");
        return invoke;
    }
}
