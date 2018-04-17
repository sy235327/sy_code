package com.demo.test;

/**
 * 联系人javabean
 * name名字
 * handset手机号
 * category类别
 */
public class Contact {
    private String name;
    private String handset;
    private String category;

    public Contact() {
    }

    public Contact(String name, String handset, String category) {
        this.name = name;
        this.handset = handset;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHandset() {
        return handset;
    }

    public void setHandset(String handset) {
        this.handset = handset;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", handset='" + handset + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
