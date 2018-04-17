package com.zixue.entity;

public class student2 {
	 private int id;
     private String name;
     private String age;
     private String phone;
     private String eamil;
     private teacher tea;
     private int clid;//外键
     
	public int getClid() {
		return clid;
	}
	public void setClid(int clid) {
		this.clid = clid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEamil() {
		return eamil;
	}
	public void setEamil(String eamil) {
		this.eamil = eamil;
	}
	public teacher getTea() {
		return tea;
	}
	public void setTea(teacher tea) {
		this.tea = tea;
	}

}
