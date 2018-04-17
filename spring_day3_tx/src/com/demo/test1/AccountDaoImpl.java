package com.demo.test1;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {
    /* 将这段代码放置到JdbcDaoSupport父类当中
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }*/

    /**
     * 付款
     * @param out 付款方
     * @param money 金额
     */
    @Override
    public void outMoney(String out, double money) {
//        jdbcTemplate.update(sql,agrs);
//        super.getJdbcTemplate().update(sql,agrs);
        super.getJdbcTemplate().update("UPDATE t_account SET money=money-? WHERE name=?",money,out);
    }

    /**
     * 收款
     * @param in 收款方
     * @param money 金额
     */
    @Override
    public void inMoney(String in, double money) {
//        jdbcTemplate.update(sql,agrs);
        super.getJdbcTemplate().update("UPDATE t_account SET money=money+? WHERE name=?",money,in);
    }
}
