package com.demo.text1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

/**
 * 测试jdbc的模板类,使用IOC方式
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Demo1_1 {
    //注入属性
    @Resource(name="jdbcTemplate")
    private JdbcTemplate template = null;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    /**
     * update(String sql,Object...params) 可以完成增删改查操作,使用方式和DBUtils差不多
     */
    @Test
    public void run1(){
        template.update("INSERT into t_account values(null,?,?)","大桥未久",10000);
    }

    @Test
    public void run2(){
        template.update("UPDATE t_account SET name=? WHERE id=?","苍井空",1);
    }

    @Test
    public void run3(){
        template.update("DELETE FROM t_account WHERE id=?",1);
    }

    /**
     * 测试查询: 通过主键查询一条记录
     */
    @Test
    public void run4(){
        Account ac = template.queryForObject("select * from t_account where id=?", new BeanMapper(), 2);
        System.out.println(ac);
    }

    /**
     * 查询所有的数据,返回一个list集合泛型为Javabean
     */
    @Test
    public void run5(){
        List<Account> query = template.query("select * from t_account", new BeanMapper());
        System.out.println(Arrays.toString(query.toArray()));
    }
}

/**
 * 自己手动来封装数据(一行一行封装数据)
 */
class BeanMapper implements RowMapper<Account>{

    @Override
    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
        Account ac = new Account();
        ac.setId(rs.getInt("id"));
        ac.setName(rs.getString("name"));
        ac.setMoney(rs.getDouble("money"));
        return ac;
    }
}