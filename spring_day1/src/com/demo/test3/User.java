package com.demo.test3;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * 演示集合注入的方式
 */
public class User {
    private String[] arrs;
    private List<String> list;
    private Map<String,String> map;
    private Properties pro;

    public void setPro(Properties pro) {
        this.pro = pro;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public void setArrs(String[] arrs) {
        this.arrs = arrs;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "User{" +
                "arrs=" + Arrays.toString(arrs) +
                ", list=" + list +
                ", map=" + map +
                ", pro=" + pro +
                '}';
    }
}
