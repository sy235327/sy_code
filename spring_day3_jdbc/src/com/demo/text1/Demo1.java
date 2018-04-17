package com.demo.text1;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * 演示JDBC的模板类
 */
public class Demo1 {

    /**
     * 演示模板类 , new的方式
     */
    @Test
    public void run1(){
        //Spring框架提供了内置的连接池,不想使用内置,可以整合其他的链接池 DBCP C3P0
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/spring_day03");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("123");
        //创建模板类
        JdbcTemplate template = new JdbcTemplate();
        //设置连接池
        template.setDataSource(dataSource);

        //完成操作,操作和DBUtils差不多
        template.update("insert into t_account values(null,?,?)","冠希",10000);
    }


}
