package com.demo.junit;

import com.demo.mapper.UserMapper;
import com.demo.mybatis1.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

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
}
