package com.demo.log4j;

import org.apache.log4j.Logger;
import org.junit.Test;



/**
 * 演示日志用法
 */
public class Log4jTest {
    //创建日志对象
    private Logger log = Logger.getLogger(Log4jTest.class);

    @Test
    public void run1(){
        System.out.println("执行了...");
        /**
         * 使用日志的方式在控制台打印,可以在配置文件中修改配置
         * log4j.rootLogger=info, stdout -默认,可以将info改off关闭日志在控制台输出,还可以设置级别,级别低的也不会输出
         */
        log.info("执行了");
    }
}
