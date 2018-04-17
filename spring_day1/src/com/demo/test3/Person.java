package com.demo.test3;

/**
 * 使用构造方法注入对象
 */
public class Person {
    private Car1 car1;
    private String pname;

    public Person(Car1 car1, String pname) {
        this.car1 = car1;
        this.pname = pname;
    }

    @Override
    public String toString() {
        return "Person{" +
                "car1=" + car1 +
                ", pname='" + pname + '\'' +
                '}';
    }
}
