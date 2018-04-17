package com.demo.junit;

import com.demo.mapper.OrderMapper;
import com.demo.mapper.UserMapper;
import com.demo.mybatis1.entity.Orders;
import com.demo.mybatis1.entity.QueryVo;
import com.demo.mybatis1.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class MybatisMapperTest2 {

    /**
     * 一对一查询
     */
    @Test
    public void run1(){
        try {
            //获取SqlSessionFactory对象
            String resource = "sqlMapConfig.xml";
            InputStream inResource = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inResource);

            //获取sqlSession
            SqlSession sqlSession = sqlSessionFactory.openSession();
            OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);

            List<Orders> orders = mapper.selectOrders();
            System.out.println(Arrays.asList(orders));
            for (Orders o : orders){
                System.out.println(o.getUser());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 一对多查询
     */
    @Test
    public void run2(){
        try {
            //获取SqlSessionFactory对象
            String resource = "sqlMapConfig.xml";
            InputStream inResource = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inResource);

            //获取sqlSession
            SqlSession sqlSession = sqlSessionFactory.openSession();
            OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);

            List<User> users = mapper.selectUserList();
            System.out.println(Arrays.asList(users));
            for (User user : users){
                System.out.println(user.getUsername()+"   "+user.getOrdersList());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
