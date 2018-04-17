package com.demo.test2;

public class CustomerServiceImpl {
    //提供成员属性,提供set方法
    public CustomerDaoImpl CustomerDao;

    public void setCustomerDao(CustomerDaoImpl customerDao) {
        CustomerDao = customerDao;
    }

    public void save(){
        System.out.println("业务层service...");
//        new CustomerDaoImpl().save(); 交给框架容器管理不再直接new,框架直接通过反射(对象提供set方法和属性),注入对象
        CustomerDao.save();
    }
}
