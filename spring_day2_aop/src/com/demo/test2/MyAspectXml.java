package com.demo.test2;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 切面类: 切入点和通知/增强
 */
public class MyAspectXml {

    /**
     * 通知/增强
     */
    public void log(){
        System.out.println("记录日志");
    }

    /**
     * 最终通知/增强: 方法执行成功或者出现异常 都会执行
     */
    public void after(){
        System.out.println("最终通知");
    }

    /**
     * 后置通知: 方法成功执行之后通知,程序出现异常,后置通知是不会运行的
     */
    public void afterReturn(){
        System.out.println("后置通知");
    }

    /**
     * 环绕通知: 方法执行之前和方法执行之后进行通知.默认的情况下,目标对象的方法不能执行,需要手动让目录对象执行
     */
    public void around(ProceedingJoinPoint joinPoint){
        System.out.println("环绕通知1");

        try {
            //手动让目标对象的方法去执行
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        System.out.println("环绕通知2");
    }
}
