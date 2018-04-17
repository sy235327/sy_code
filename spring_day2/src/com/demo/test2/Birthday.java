package com.demo.test2;

import java.util.Calendar;

public class Birthday {
    private int year;
    private int month;
    private int day;

    /**
     * 打印传递的年月日
     */
    public void  display(){
        System.out.println(String.format(("%d年%d月%d日"),year,month,day));
    }

    public Birthday(){

    }

    /**
     * 传递生日的年月日
     * @param year 年
     * @param month 月
     * @param day 日
     */
    public Birthday(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getAge(){
        //获取当前年,月日
        Calendar cal = Calendar.getInstance();
        int yearNow = cal.get(Calendar.YEAR); //当前年
        int monthNow = cal.get(Calendar.MONTH); //当前月
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH); //当前日

        //当前年减去生日年等到岁数,下面继续判断是否满岁
        int age = yearNow - year;

        //如果当前月分小于生日的月份就是没有满当前岁数需要-1
        if (monthNow <= month) {
            //判断当前月份是否等于生日月份,如果等于继续判断 日
            if (monthNow == month) {
                //判断当前日是否小于生日
                if (dayOfMonthNow < day)
                    //如果小于 岁数减-1
                    age--;
            }else{
                //如果当前月份小于而且而且不等于生日的月份 岁数减-1
                age--;
            }
        }
        //返回岁数
        return age;

    }

    public static void main(String []args){
        Birthday b = new Birthday(1990,4,1);
        int age = b.getAge();
        System.out.println(age);
    }
}
