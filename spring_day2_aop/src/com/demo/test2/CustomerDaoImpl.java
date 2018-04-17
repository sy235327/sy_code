package com.demo.test2;

public class CustomerDaoImpl implements CustomerDao {

    @Override
    public void save() {
        //模拟异常
//        int i = 10/0;
        System.out.println("保存客户");
    }

    @Override
    public void update() {
        System.out.println("修改客户");
    }
}
