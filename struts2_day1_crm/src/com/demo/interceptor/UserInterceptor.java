package com.demo.interceptor;

import com.demo.domain.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import org.apache.struts2.ServletActionContext;

/**
 * 自定义拦截器,判断当前系统是否已经登录,如果登录,继续执行,如果没有登录,跳转到登录页面
 */
public class UserInterceptor extends MethodFilterInterceptor {

    /**
     * 进行拦截的方法
     * @param actionInvocation
     * @return
     * @throws Exception
     */
    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        // 获取session对象
        User user =(User) ServletActionContext.getRequest().getSession().getAttribute("user");
        System.out.println(user+"             1111        ");
        if (user == null){
            //如果等于null 没有登录,直接返回一个字符串后面的拦截器就不会执行了
            return "login";
        }
        //继续执行默认的拦截器
        return actionInvocation.invoke();
    }
}
