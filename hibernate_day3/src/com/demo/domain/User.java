package com.demo.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * 系统用户
 * 用户有多个角色,角色也有多个用户
 * 多对多
 */
public class User {
    private Long uid;
    private String username;
    private String password;

    //多对多,在两个多方都需要编写集合
    private Set<Role> roles = new HashSet<Role>();

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getUid() {
        return uid;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
