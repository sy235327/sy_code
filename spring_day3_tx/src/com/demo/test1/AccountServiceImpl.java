package com.demo.test1;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

public class AccountServiceImpl implements AccountService{
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    //注入事务的模板类
    private TransactionTemplate transactionTemplate;

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    /**
     * 转账
     * @param out 收款方
     * @param in  付款方
     * @param monet 金额
     */
    @Override
    public void par(String out, String in, double monet) {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {

            //事务的执行,如果没有问题,提交.如果出现了异常,回滚事务
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                //付款
                accountDao.outMoney(out,monet);

                //模拟异常
                int a = 10/0;

                //收款
                accountDao.inMoney(in,monet);
            }
        });
    }
}
