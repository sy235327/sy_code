package com.zixue.entity;

import java.util.HashSet;
import java.util.Set;

public class teacher {
	private int id;
	private String name;
	private String subject;
	private String phone;
	private Set<student2> se=new HashSet<student2>();

	public Set<student2> getSe() {
		return se;
	}

	public void setSe(Set<student2> se) {
		this.se = se;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Set<student2> getSet() {
		return se;
	}
	public void setSet(Set<student2> set) {
		this.se = set;
	}
    
}
