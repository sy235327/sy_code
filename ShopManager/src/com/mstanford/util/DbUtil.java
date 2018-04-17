package com.mstanford.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	/**
	 * 定义JDBC的名称
	 * 定义JDBC的路径
	 * 定义JDBC的用户名
	 * 定义JDBC的密码
	 * 
	 */
	private final String jdbcName = "com.mysql.jdbc.Driver";
	private final String dbUrl = "jdbc:mysql://localhost:3306/user";
	private final String user = "root";
	private final String pssaword = "123";
	Connection conn = null;
	//加载数据库的驱动：
	public Connection getCon() {
		try {
			Class.forName(jdbcName);
			conn = DriverManager.getConnection(dbUrl, user, pssaword);
			System.out.println("数据库连接成功！");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
		
		
	}
	//关闭数据库的连接：
	public void closeCon(){
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		DbUtil dbUtil = new DbUtil();
		dbUtil.getCon();
	}
	

}
