package com.demo.mybatis1.dao;

import com.demo.mybatis1.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserDaoImpl implements UserDao {
    private SqlSessionFactory sqlSessionFactory;

    public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public User findUserById(Integer id){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user =sqlSession.selectOne("user.findUserById",id);
        return user;
    }
}
