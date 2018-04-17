package com.mstanford.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	/**
	 * ����JDBC������
	 * ����JDBC��·��
	 * ����JDBC���û���
	 * ����JDBC������
	 * 
	 */
	private final String jdbcName = "com.mysql.jdbc.Driver";
	private final String dbUrl = "jdbc:mysql://localhost:3306/user";
	private final String user = "root";
	private final String pssaword = "123";
	Connection conn = null;
	//�������ݿ��������
	public Connection getCon() {
		try {
			Class.forName(jdbcName);
			conn = DriverManager.getConnection(dbUrl, user, pssaword);
			System.out.println("���ݿ����ӳɹ���");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
		
		
	}
	//�ر����ݿ�����ӣ�
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
