package com.demo.test2;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

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
    public void par(String out, String in, double monet) {
        //付款
        accountDao.outMoney(out,monet);

        //模拟异常
        int a = 10/0;

        //收款
        accountDao.inMoney(in,monet);
    }
}
