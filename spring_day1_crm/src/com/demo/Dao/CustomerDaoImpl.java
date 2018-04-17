package com.demo.Dao;

public class CustomerDaoImpl implements CustomerDao{
    @Override
    public void save() {
        System.out.println("持久层保存客户...");
    }
}
