package com.mstanford.model;

public class User {
	//�������е�����Ҫһ��
	private int userID;
	private String userPwd;
	//��дget��set����
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
