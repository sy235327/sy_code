package com.demo.test3;

/**
 * 演示构造方法的方式
 */
public class Car1 {
    private String cname;
    private Double price;

    public Car1(String cname, Double price) {
        this.cname = cname;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car1{" +
                "cname='" + cname + '\'' +
                ", price=" + price +
                '}';
    }
}
