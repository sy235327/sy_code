package com.demo.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 使用ArrayLiat创建一个通信录列表，列表用于存储联系人信息，包括手机号码，姓名和类别(如同事，朋友，同学等)，要求完成如下操作:
 1，联系人数据的录入，求联系人的数目。
 2，将一条新的联系人数据插入到列表第i个位置。
 3，将列表第j个位置处的联系人数据删除。
 4，更新列表第k个位置处的联系人数据
 5，查询列表中所有属于朋友类别的记录，并输出这些记录的信息以及条目数
 */
public class Test {
    private static List<Contact> list = new ArrayList<Contact>();

    /**
     * 主方法
     * @param args
     */
    public static void main(String[] args) {
        while(true) {
            lajixinxi();
            //接收用户数据
            String name;
            String handset;
            String category;
            Contact contact;
            Scanner sca = new Scanner(System.in);
            switch(sca.nextInt()){
                case 1:
                    System.out.println("1，联系人数据的录入，求联系人的数目。");
                    System.out.println("请输入联系人信息");
                    System.out.println("联系人名称");
                    name = sca.next();
                    System.out.println("联系人手机号");
                    handset = sca.next();
                    System.out.println("类别");
                    category = sca.next();
                    contact = contact(name, handset, category);
                    addContactList(contact);
                    System.out.println("长度为: "+list.size());
                    break;
                case 2:
                    System.out.println("2，将一条新的联系人数据插入到列表第i个位置。");
                    System.out.println("联系人名称");
                    name = sca.next();
                    System.out.println("联系人手机号");
                    handset = sca.next();
                    System.out.println("类别");
                    category = sca.next();
                    System.out.println("索引");
                    int i = sca.nextInt();
                    if (i>=list.size()||i<0){
                        System.out.println("没有这个索引");
                        break;
                    }
                    contact = contact(name, handset, category);
                    addContactList(i,contact);
                    break;
                case 3:
                    System.out.println("3，将列表第j个位置处的联系人数据删除。");
                    System.out.println("索引");
                    int j = sca.nextInt();
                    if (j>=list.size()||j<0){
                        System.out.println("没有这个索引");
                        break;
                    }
                    removeContactList(j);
                    break;
                case 4:
                    System.out.println("4，更新列表第k个位置处的联系人数据");
                    System.out.println("索引");
                    int k = sca.nextInt();
                    System.out.println("联系人名称");
                    name = sca.next();
                    System.out.println("联系人手机号");
                    handset = sca.next();
                    System.out.println("类别");
                    category = sca.next();
                    updateContactList(k,contact(name,handset,category));
                    break;
                case 5:
                    System.out.println("5，查询列表中所有属于朋友类别的记录，并输出这些记录的信息以及条目数");
                    System.out.println("请输入类别,查什么类别输入什么类别");
                    category = sca.next();
                    List<Contact> contactList = getContactList(category);
                    System.out.println("长度: "+contactList.size());
                    for (Contact contact1 : contactList){
                        System.out.println(contact1);
                    }
                    break;
                default :
                    System.out.println("没有这个选择");
            }
        }
    }

    public static void lajixinxi(){
        System.out.println("1，联系人数据的录入，求联系人的数目。");
        System.out.println("2，将一条新的联系人数据插入到列表第i个位置。");
        System.out.println("3，将列表第j个位置处的联系人数据删除。");
        System.out.println("4，更新列表第k个位置处的联系人数据");
        System.out.println("5，查询列表中所有属于朋友类别的记录，并输出这些记录的信息以及条目数");
    }
    /**
     * 这个存储默认数据,可以不调用
     * 存储数据
     * @return
     */
    public static List<Contact> contactList(){

        list.add(new Contact("大桥未久","110","一号女友"));
        list.add(new Contact("大桥未久","120","二号女友"));
        list.add(new Contact("大桥未久","130","三号女友"));

        list.add(new Contact("切格瓦拉","140","领袖"));
        list.add(new Contact("毛大大","150","领袖"));

        return list;
    }
    /**
     * 查询集合中指定索引数据
     */
    public static Contact get(int k){
        return list.get(k);
    }
    /**
     * 封装用户输入的数据到联系人对象
     * @param name 联系人名称
     * @param handset 联系人电话
     * @param category 类别
     * @return 返回一个联系人名称
     */
    public static Contact contact(String name, String handset, String category){
        return new Contact(name,handset,category);
    }

    /**
     * 添加联系人
     * @param contact 联系人信息
     */
    public static void addContactList(Contact contact){
        list.add(contact);
    }

    /**
     * 向指定的索引添加联系人
     * @param i 集合索引
     * @param contact 联系人信息
     */
    public static void addContactList(int i,Contact contact){
        list.add(i,contact);
    }

    /**
     * 删除指定索引的联系人
     * @param j 索引
     */
    public static void removeContactList(int j){
        list.remove(j);
    }

    /**
     * 修改指定索引的联系人
     * @param contact
     */
    public static void updateContactList(int k,Contact contact){
        list.set(k,contact);
    }

    /**
     * 查询指定类别的联系人
     * @param category 类别名称
     * @return 返回一个集合存储对应类别名称的联系人数据
     */
    public static List<Contact> getContactList(String category){
        ArrayList<Contact> arr = new ArrayList<Contact>();

        for (Contact contact : list){
            if (contact.getCategory().equals(category)){
                arr.add(contact);
            }
        }
        return arr;
    }
}
