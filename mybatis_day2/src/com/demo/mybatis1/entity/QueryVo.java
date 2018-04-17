package com.demo.mybatis1.entity;

import java.io.Serializable;
import java.util.List;

/**
 * User的包装类
 */
public class QueryVo implements Serializable{
    public static final long serializableUID=1L;

    private User user;

    List<Integer> idIntegers;

    Integer[] ids;

    public List<Integer> getIdIntegers() {
        return idIntegers;
    }

    public void setIdIntegers(List<Integer> idIntegers) {
        this.idIntegers = idIntegers;
    }

    public Integer[] getIds() {
        return ids;
    }

    public void setIds(Integer[] ids) {
        this.ids = ids;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
