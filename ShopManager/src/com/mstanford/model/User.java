package com.mstanford.model;

public class User {
	//和数据中的名称要一致
	private int userID;
	private String userPwd;
	//重写get和set方法
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	@Override
	public String toString() {
		return "User [userID=" + userID + ", userPwd=" + userPwd + "]";
	}

}
