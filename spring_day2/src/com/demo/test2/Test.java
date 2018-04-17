package com.demo.test2;

public class Test {
    public static double sun =100;
    public static double height(double height,int num){
        if (num==1){
            double d = height/2;
            sun += d;
            return d;
        }else{
            double d = height/2;
            sun += d;
            return height(d,num-1);
        }
    }

    public static void main(String []args){
        System.out.println(height(100,10));
        System.out.println(sun);
    }

}
