package com.demo.domain;

import java.util.Date;

/**
 * javabean
 */
public class User {
    private String uid;
    private String username;
    private String password;
    private String name;
    private String email;
    private String telephone;
    private Date birthdar;
    private String sex;
    private int state;//账号注册邮箱是否激活
    private String code;//激活码

    public User() {
    }

    public User(String uid, String username, String password, String name, String email, String telephone, Date birthdar, String sex, int state, String code) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.telephone = telephone;
        this.birthdar = birthdar;
        this.sex = sex;
        this.state = state;
        this.code = code;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setBirthdar(Date birthdar) {
        this.birthdar = birthdar;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUid() {
        return uid;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    public Date getBirthdar() {
        return birthdar;
    }

    public String getSex() {
        return sex;
    }

    public int getState() {
        return state;
    }

    public String getCode() {
        return code;
    }

}
