package com.demo.test1;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * 注解方式的切面类
 */
//@Aspect注解 相当于<aop:aspect ref="myAspecAnnotation"> 配置切面类
@Aspect
public class MyAspecAnnotation {
    /**
     * 环绕通知
     */
    @Around(value="MyAspecAnnotation.function()")
    public void around(ProceedingJoinPoint joinPoint){
        System.out.println("环绕通知1");

        try {
            //切入点方法运行位置,让目标对象的方法执行
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        System.out.println("环绕通知2");
    }

    /**
     * @Before(value="切入点的表达式")前置通知
     */
    @Before(value="MyAspecAnnotation.function()")
    public void log(){
        System.out.println("记录日志");
    }

    /**
     * 最终通知: 方法执行成功或者有异常,都会执行
     */
    @After(value="MyAspecAnnotation.function()")
    public void after(){
        System.out.println("最终通知");
    }

    /**
     * 自定义切入点 @Pointcut
     * 在自定义的方法上写切入点 execution(表达式)
     * 其他的方法的@After标签中value=类名和自定义切入点注解的方法
     * @After(value="MyAspecAnnotation.function()")
     */
    @Pointcut(value="execution(void com.demo.test1.CustomerDaoImpl.save())")
    public void function(){ }
}
