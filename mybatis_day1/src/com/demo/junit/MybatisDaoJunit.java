package com.demo.junit;

import com.demo.mybatis1.dao.UserDao;
import com.demo.mybatis1.dao.UserDaoImpl;
import com.demo.mybatis1.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MybatisDaoJunit {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void Before() throws IOException {
        String resource = "sqlMapConfig.xml";
        InputStream inResource = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inResource);
    }
    @Test
    public void run(){
        UserDao dao = new UserDaoImpl(sqlSessionFactory);
        User user = dao.findUserById(29);
        System.out.println(user);
    }
}
