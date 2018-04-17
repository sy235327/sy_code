package com.demo.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * 系统角色
 * 用户有多个角色,角色也有多个用户
 * 多对多
 */
public class Role {
    private Long rid;
    private String rname;

    //多对多,在两个多方都需要编写集合
    private Set<User> users = new HashSet<User>();

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }
}
