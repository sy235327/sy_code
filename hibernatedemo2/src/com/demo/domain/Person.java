package com.demo.domain;

/**
 * 使用字符串做主键
 */
public class Person {
    private String pid;
    private String pname;

    public void setPid(String pid) {
        this.pid = pid;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPid() {
        return pid;
    }

    public String getPname() {
        return pname;
    }
}
