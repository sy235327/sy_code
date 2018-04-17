package com.demo.jdbc;


import com.mysql.jdbc.ConnectionGroupManager;

import java.sql.*;

/**
 * 使用jdbc链接数据库
 * */
public class Test {
    public static void main(String[] args) {
        //声明 链接者对象,执行者对象,结果集处理对象
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet resultSet = null;

        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");

            String sql = "select * FROM user where id=?";
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis","root","123");
            pre = con.prepareStatement(sql);
            pre.setInt(1,1);
            resultSet = pre.executeQuery();
            while(resultSet.next()){
                System.out.println(resultSet.getString("id")+"   "+resultSet.getString("username"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
