package com.demo.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;


/**
 * hibernate框架的工具类
 */
public class HibernateUtils {
    //声明一个加载配置对象
    private static final Configuration CONFIG;

    //生命一个工厂类对象
    private static final SessionFactory FACTORY;

    static{
        //加载配置
        CONFIG = new Configuration().configure();

        //创建SessionFactory对象,工厂对象
        FACTORY = CONFIG.buildSessionFactory();
    }

    /**
     * 从工厂对象获取一个session对象，会话技术
     * @return
     */
    public static Session getSession(){
        return FACTORY.openSession();
    }

    /**
     * 将session绑定到线程上面,从线程上面获取session
     * @return
     */
    public static Session getCurrentSession(){
        return FACTORY.getCurrentSession();
    }

    /**
     * 关闭资源
     * @param session 传递一个与数据库的会话技术
     */
    public static void close(Session session){
        session.close();
    }
}
