package com.demo.test1;

public interface AccountService {
    /**
     * 转账
     * @param out 收款方
     * @param in  付款方
     * @param monet 金额
     */
    void par(String out,String in,double monet);
}
