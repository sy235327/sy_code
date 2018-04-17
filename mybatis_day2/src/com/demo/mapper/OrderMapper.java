package com.demo.mapper;

import com.demo.mybatis1.entity.Orders;
import com.demo.mybatis1.entity.User;

import java.util.List;

public interface OrderMapper {
    //查询订单order所有数据
    List<Orders> selectOrdersList();

    //一对一关联查询 以订单为中心关联用户
    List<Orders> selectOrders();

    //一对多关联
    List<User> selectUserList();
}
