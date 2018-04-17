package com.demo.service;

import com.demo.dao.CustomerDao;
import com.demo.dao.LinkmanDao;
import com.demo.domain.Customer;
import com.demo.domain.Linkman;
import com.demo.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

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

    /**
     * 查询所有的联系人
     * @return 联系人集合
     * @param criteria
     */
    public List<Linkman> findAll() {
        Session session = HibernateUtils.getCurrentSession();
        //开启事务
        Transaction tr = session.beginTransaction();
        //接收查询到数据
        List<Linkman> mans = null;
        try{
            mans = new LinkmanDao().findAll();

            //提交事务
            tr.commit();
        }catch(Exception e){
            //回滚事务
            tr.rollback();
            System.out.println(e);
        }
        return mans;
    }

    /**
     * 从servlet层获取离线条件查询对象,调用dao层
     * @param criteria 离线条件查询对象
     * @return 联系人集合
     */
    public List<Linkman> findAll(DetachedCriteria criteria) {
        Session session = HibernateUtils.getCurrentSession();
        //开启事务
        Transaction tr = session.beginTransaction();
        //接收查询到数据
        List<Linkman> mans = null;
        try{
            mans = new LinkmanDao().findAll(criteria);

            //提交事务
            tr.commit();
        }catch(Exception e){
            //回滚事务
            tr.rollback();
            System.out.println(e);
        }
        return mans;
    }
}
