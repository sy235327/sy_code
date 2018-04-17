package com.demo.utils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 工具类
 * 通过c3p0的数据库连接池的API获取链接
 *
 * 方式2(此工具类将链接对象和当前线程绑定 并开启事务):(每一个请求就是一个线程)
 * 可以将connection对象绑定当前线程上
     jdk中有一个ThreadLocal类,
     ThreadLocal 实例通常是类中的 private static 字段，
     它们希望将状态与某一个线程（例如，用户 ID 或事务 ID）相关联。
     ThreadLocal的方法:
     构造:
     new ThreadLocal()
     set(Object value):将内容和当前线程绑定
     Object get():获取和迪昂前线程绑定的内容
     remove():将当前线程和内容解绑
     内部维护了map集合
     map.put(当前线程,内容);
     map.get(当前线程)
     map.remove(当前线程)
 */
public class DataSourceUtils {
    //创建一个c3p0数据库链接池对象
    private static ComboPooledDataSource ds = new ComboPooledDataSource();
    private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

    /**
     * 获取连接池
     * */
    public static DataSource getDataSource(){
        return ds;
    }

    /**
     * 从当前线程获取链接
     * */
    public static Connection getConnection() throws SQLException {
        //从线程上获取
        Connection con = tl.get();
        //判断是否为空(第一次访问结果为null)
        if (con==null){
            con = ds.getConnection();
            //绑定线程
            tl.set(con);
        }
        return con;
    }

    /**
     * 释放资源
     * @param re 结果集对象
     * @param pre sql语句执行者对象
     * @param con 数据库链接对象
     */
    public static void close(ResultSet re, PreparedStatement pre, Connection con){
        if (re != null && pre != null && con!= null) {
            try {
                re.close();
                pre.close();
                closeCon(con);
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }

    /**
     * 释放资源
     * @param re 结果集对象
     * @param pre sql语句执行者对象
     */
    public static void close(ResultSet re, PreparedStatement pre){
        if (re != null && pre != null) {
            try {
                re.close();
                pre.close();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }

    /**
     * 释放资源
     * @param pre sql语句执行者对象
     * @param con 数据库链接对象
     */
    public static void close(PreparedStatement pre,Connection con){
        if (pre != null && con!= null) {
            try {
                pre.close();
                closeCon(con);
            } catch (Exception ex) {
                System.out.println(ex);
            }
            //无论关不关闭 将值设为null  jvm垃圾回收机制回快速回收
            pre = null;
            con = null;
        }
    }
    /**
     * 调用close(),并且 当前线程和数据库链接对象解绑
     * @param con 绑定了当前线程的数据库链接对象
     * */
    public static void closeCon(Connection con){
        if (con!= null) {
            try {
                con.close();
                //和当前线程解绑
                tl.remove();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }

    /**
     * 开启事务
     * @throws SQLException
     */
    public static void startTransaction() throws SQLException {
        //获取链接   开启事务
        getConnection().setAutoCommit(false);
    }

    /**
     * 提交事务
     */
    public static void commitAndClose(){
        try {
            //获取链接
            Connection con = getConnection();
            //提交事务
            con.commit();
            //解绑
            tl.remove();
            //关闭资源
            closeCon(con);
        }catch(SQLException sqlex){
            sqlex.getMessage();
        }
    }

    /**
     * 事务回滚
     */
    public static void rollbackAndClose(){
        try {
            //获取链接
            Connection con = getConnection();
            //提交事务
            con.rollback();
            //解绑
            tl.remove();
            //关闭资源
            closeCon(con);
        }catch(SQLException sqlex){
            sqlex.getMessage();
        }
    }
}
