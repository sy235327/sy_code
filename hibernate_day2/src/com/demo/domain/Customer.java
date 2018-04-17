package com.demo.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * 客户的javabean
 * 一对多
 * 一方
 * 主表
 * 在主表的javabean中写一个Set集合(hibernate框架默认就是set集合),必须手动初始化
 *
 * 一方使用集合和配置文件去维护外键
 */
public class Customer {
     /*
     `cust_id` BIGINT(32) NOT NULL AUTO_INCREMENT COMMENT '客户编号(主键)',
    `cust_name` VARCHAR(32) NOT NULL COMMENT '客户名称(公司名称)',
    `cust_user_id` BIGINT(32) DEFAULT NULL COMMENT '负责人id',
    `cust_create_id` BIGINT(32) DEFAULT NULL COMMENT '创建人id',
    `cust_source` VARCHAR(32) DEFAULT NULL COMMENT '客户信息来源',
    `cust_industry` VARCHAR(32) DEFAULT NULL COMMENT '客户所属行业',
    `cust_level` VARCHAR(32) DEFAULT NULL COMMENT '客户级别',
    `cust_linkman` VARCHAR(64) DEFAULT NULL COMMENT '联系人',
    `cust_phone` VARCHAR(64) DEFAULT NULL COMMENT '固定电话',
    `cust_mobile` VARCHAR(16) DEFAULT NULL COMMENT '移动电话',
    */

     //使用基本类型的包装类，默认是null，传递到数据库就不会成为0这些默认值了
    private Long cust_id;
    private String cust_name;
    private Long cust_user_id;
    private Long cust_create_id;
    private String cust_source;
    private String cust_industry;
    private String cust_level;
    private String cust_linkman;
    private String cust_phone;
    private String cust_mobile;
    //在主表的javabean中写一个Set集合(hibernate框架默认就是set集合),必须手动初始化
    private Set<Linkman> linkmans = new HashSet<Linkman>();

    //添加数据，使用配置文件中设置的update跟新表结构和数据
    //private String info;


    public void setLinkmans(Set<Linkman> linkmans) {
        this.linkmans = linkmans;
    }

    public void setCust_id(Long cust_id) {
        this.cust_id = cust_id;
    }

    public void setCust_name(String cust_name) {
        this.cust_name = cust_name;
    }

    public void setCust_user_id(Long cust_user_id) {
        this.cust_user_id = cust_user_id;
    }

    public void setCust_create_id(Long cust_create_id) {
        this.cust_create_id = cust_create_id;
    }

    public void setCust_source(String cust_source) {
        this.cust_source = cust_source;
    }

    public void setCust_industry(String cust_industry) {
        this.cust_industry = cust_industry;
    }

    public void setCust_level(String cust_level) {
        this.cust_level = cust_level;
    }

    public void setCust_linkman(String cust_linkman) {
        this.cust_linkman = cust_linkman;
    }

    public void setCust_phone(String cust_phone) {
        this.cust_phone = cust_phone;
    }

    public void setCust_mobile(String cust_mobile) {
        this.cust_mobile = cust_mobile;
    }

    public Long getCust_id() {
        return cust_id;
    }

    public String getCust_name() {
        return cust_name;
    }

    public Long getCust_user_id() {
        return cust_user_id;
    }

    public Long getCust_create_id() {
        return cust_create_id;
    }

    public String getCust_source() {
        return cust_source;
    }

    public String getCust_industry() {
        return cust_industry;
    }

    public String getCust_level() {
        return cust_level;
    }

    public String getCust_linkman() {
        return cust_linkman;
    }

    public String getCust_phone() {
        return cust_phone;
    }

    public String getCust_mobile() {
        return cust_mobile;
    }

    public Set<Linkman> getLinkmans() {
        return linkmans;
    }
}
