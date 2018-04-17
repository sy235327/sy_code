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
import org.apache.logging.log4j.core.config.Order;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class MybatisMapperTest {

    @Test
    public void run1(){
        try {
            //获取SqlSessionFactory对象
            String resource = "sqlMapConfig.xml";
            InputStream inResource = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inResource);

            //获取sqlSession
            SqlSession sqlSession = sqlSessionFactory.openSession();

            //SqlSession生成实现类(给接口)
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User user = mapper.findUserById(10);
            System.out.println(user);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试pojo的包装类封装数据查询
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

            //SqlSession生成接口实现类(不需要我们自己编写dao的垃圾代码)
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            //封装包装类vo
            QueryVo vo = new QueryVo();
            User user = new User();
            user.setUsername("小");
            vo.setUser(user);
            List<User> users = mapper.findUserByUsername(vo);

            System.out.println(Arrays.asList(users));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 聚合函数count查询
     */
    @Test
    public void run3(){
        try {
            //获取SqlSessionFactory对象
            String resource = "sqlMapConfig.xml";
            InputStream inResource = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inResource);

            //获取sqlSession
            SqlSession sqlSession = sqlSessionFactory.openSession();

            //SqlSession生成接口实现类(不需要我们自己编写dao的垃圾代码)
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            Integer i = mapper.countUser();
            System.out.println(i);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //查询订单表order的所有数据
    @Test
    public void run4(){
        try {
            //获取SqlSessionFactory对象
            String resource = "sqlMapConfig.xml";
            InputStream inResource = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inResource);

            //获取SqlSession
            SqlSession sqlSession = sqlSessionFactory.openSession();
            OrderMapper order = sqlSession.getMapper(OrderMapper.class);
            List<Orders> orders = order.selectOrdersList();
            System.out.println(Arrays.asList(orders));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //根据用户名称和性别查询数据库
    @Test
    public void run5(){
        try {
            //获取SqlSessionFactory对象
            String resource = "sqlMapConfig.xml";
            InputStream inResource = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inResource);

            //获取SqlSession
            SqlSession sqlSession = sqlSessionFactory.openSession();
            UserMapper usermapper = sqlSession.getMapper(UserMapper.class);

            //创建一个user对象
            User user = new User();
//            user.setUsername("王五");
            user.setSex("2");

            List<User> users = usermapper.selectUserBySexAndUsername(user);
            System.out.println(Arrays.asList(users));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 多个ID查询多个用户
     */
    @Test
    public void run6(){
        try {
            //获取SqlSessionFactory对象
            String resource = "sqlMapConfig.xml";
            InputStream inResource = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inResource);

            //获取SqlSession
            SqlSession sqlSession = sqlSessionFactory.openSession();
            UserMapper usermapper = sqlSession.getMapper(UserMapper.class);

            QueryVo vo = new QueryVo();
            /*ArrayList<Integer> ids = new ArrayList<>();
            ids.add(1);
            ids.add(10);
            ids.add(30);*/


            Integer[] ids = {1,10,30};
//            List<User> users = usermapper.selectUserByIds(ids);
            vo.setIds(ids);
            List<User> users = usermapper.selectUserByIds(vo);
            System.out.println(Arrays.asList(users));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
