package com.demo.test;



public class Test {
    public static void main(String[] args){
        int a = 2;
        int b = 5;
        int c = 4;

        if (a>b){
            if (b>c){
                System.out.println(a+" "+b+""+c);
                return;
            }else if (c>a){
                System.out.println(c+" "+a+" "+b);
                return;
            }else if (c>b){
                System.out.println(a+" "+c+" "+b);
                return;
            }
        }else{
            if (a>c){
                System.out.println(b+" "+a+" "+c);
                return;
            }else if(c>b){
                System.out.println(c+" "+b+" "+a);
                return;
            }else if (c>a){
                System.out.println(b+" "+c+" "+a);
                return;
            }
        }

    }
}
