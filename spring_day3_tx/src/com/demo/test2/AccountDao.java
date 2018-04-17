package com.demo.test2;

public interface AccountDao {
    /**
     * 付款
     * @param out 付款方
     * @param money 金额
     */
    void outMoney(String out, double money);

    /**
     * 收款
     * @param in 收款方
     * @param money 金额
     */
    void inMoney(String in, double money);
}
