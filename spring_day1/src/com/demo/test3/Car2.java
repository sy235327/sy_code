package com.demo.test3;

public class Car2 {
    private String cname;
    private Double price;

    public void setCname(String cname) {
        this.cname = cname;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car2{" +
                "cname='" + cname + '\'' +
                ", price=" + price +
                '}';
    }
}
