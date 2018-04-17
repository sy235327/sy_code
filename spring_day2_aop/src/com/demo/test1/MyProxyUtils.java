package com.demo.test1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 使用JDK的方式生成代理对象
 */
public class MyProxyUtils {
    public static UserDao getUserDao(final UserDao dao){
        //使用Proxy类生成代理对象
        UserDao proxy = (UserDao) Proxy.newProxyInstance(dao.getClass().getClassLoader(), dao.getClass().getInterfaces(), new InvocationHandler() {

            //代理对象方法一执行,invoke方法就会执行一次
            @Override//proxy参数不要用表示当前代理的对象,method代理的方法,args参数
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if("save".equals(method.getName())){
                    System.out.println("记录日志");
                    //开启事务
                    Object invoke = method.invoke(dao, args);
                    //提交事务,在这里也可以抓住异常回滚事务

                    //让dao类的seve方法或者update方法正常执行下去
                    return invoke;
                }else{
                    Object invoke = method.invoke(dao, args);
                    return invoke;
                }
            }
        });
        //返回代理对象
        return proxy;
    }
}
