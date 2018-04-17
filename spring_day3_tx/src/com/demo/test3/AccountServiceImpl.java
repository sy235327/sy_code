package com.demo.test3;

import org.springframework.transaction.annotation.Transactional;

/**
 * 注解使用spring框架的事务管理
 * @Transactional 如果在类上添加了这个注解,类中所有的方法全部都有事务了,也可以在方法中加就只有添加了注解的方法有事务,可以设置事务的属性
 */
@Transactional
public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    /**
     * 转账
     * @param out 收款方
     * @param in  付款方
     * @param monet 金额
     */
    @Override
    @Transactional()
    public void par(String out, String in, double monet) {
        //付款
        accountDao.outMoney(out,monet);

        //模拟异常
//        int a = 10/0;

        //收款
        accountDao.inMoney(in,monet);
    }
}
