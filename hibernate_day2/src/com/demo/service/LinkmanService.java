package com.demo.service;

import com.demo.dao.CustomerDao;
import com.demo.dao.LinkmanDao;
import com.demo.domain.Customer;
import com.demo.domain.Linkman;
import com.demo.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class LinkmanService {

    /**
     * 编写业务,保存联系人
     * 先把客户查询出来,设置到联系人中,再保存联系人
     * @param man
     * @param cust_id
     */
    public void save(Linkman man, Long cust_id) {

        //先获取session
        Session session = HibernateUtils.getCurrentSession();
        //开启事务
        Transaction tr = session.beginTransaction();

        try{
            //编写代码
            //先查询客户
            Customer customer = new CustomerDao().findById(cust_id);

            //设置
            man.setCustomer(customer);

            //保存联系人
            new LinkmanDao().save(man);

            //提交事务
            tr.commit();
        }catch(Exception e){
            tr.rollback();
        }
    }
}
