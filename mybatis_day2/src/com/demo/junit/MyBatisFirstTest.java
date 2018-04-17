package com.demo.junit;

import com.demo.mybatis1.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.*;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class MyBatisFirstTest {

    /**
     * 通过用户id查询用户
     */
    @Test
    public void run1(){
        try {
            //加载核心配置文件
            String resource = "sqlMapConfig.xml";
            InputStream resources = Resources.getResourceAsStream(resource);

            //创建一个SqlSessionFactory工厂
            SqlSessionFactory sqlSessionFactory= new SqlSessionFactoryBuilder().build(resources);

            //创建SqlSession
            SqlSession sqlSession = sqlSessionFactory.openSession();

            //执行sql语句 selectOne查询一个用户的信息封装到对象中
            User user = sqlSession.selectOne("user.findUserById", 10);
            System.out.println(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过用户名称模糊查询用户列表
     */
    @Test
    public void run2(){
        try {
            //加载配置获取工厂对象
            String resource = "sqlMapConfig.xml";
            File file = Resources.getResourceAsFile(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(new FileReader(file));

            //获取sqlSession
            SqlSession sqlSession = sqlSessionFactory.openSession();

            //执行sql语句 selectList查询多个用户的id封装到list中
            List<User> users =  sqlSession.selectList("user.findUserByUserName","王");

            System.out.println(Arrays.asList(users));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 添加用户
     */
    @Test
    public void run3(){
        try {
            //获取SqlSessionFactory工厂类对象
            String resource = "sqlMapConfig.xml";
            InputStream inresource = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inresource);

            //获取SqlSession对象
            SqlSession sqlSession = sqlSessionFactory.openSession();

            //创建一个对象,将对象存储到数据库中
            User user = new User();
            user.setUsername("苍老师");
            user.setSex("2");
            user.setBirthday(new Date());
            user.setAddress("dadada");

            int i = sqlSession.insert("user.insertUser",user);
            //提交事务
            sqlSession.commit();
            System.out.println(user.getId());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 跟新用户
     */
    @Test
    public void run4(){
        try {
            //获取SqlSessionFactory对象
            String resource = "sqlMapConfig.xml";
            InputStream inResource = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inResource);

            //获取sqlSession
            SqlSession sqlSession = sqlSessionFactory.openSession();
            //创建对象
            User user = new User();
            //将修改的用户的id,赋值给对象,在配置文件中使用#{id}作为修改的条件
            user.setId(25);
            user.setUsername("波多野结衣");
            user.setSex("2");
            user.setBirthday(new Date());
            user.setAddress("dadada");
            int i = sqlSession.update("updateUser", user);
            sqlSession.commit();
            System.out.println(i);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除用户
     */
    @Test
    public void run5(){
        try {
            //获取SqlSessionFactory对象
            String resource = "sqlMapConfig.xml";
            InputStream inResource = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inResource);

            //获取sqlSession
            SqlSession sqlSession = sqlSessionFactory.openSession();

            int i = sqlSession.delete("deleteUser",26);
            sqlSession.commit();
            System.out.println(i);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
