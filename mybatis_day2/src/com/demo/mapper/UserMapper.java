package com.demo.mapper;

import com.demo.mybatis1.entity.QueryVo;
import com.demo.mybatis1.entity.User;

import java.util.List;

public interface UserMapper {
    /**
     * 自动生成dao垃圾代码
     * 遵循四个原则
     * 第一个: 接口方法名 == Mapper.xml(User.xml)中id名
     * 第二个: 接口返回值类型与Mapper.xml文件中返回值类型一致
     * 第三个: 方法的入参类型(方法参数类型)与Mapper.xml中入参要一致
     * 第四个: Mapper.xml中的命名空间绑定接口
     */
    User findUserById(Integer id);

    List<User> findUserByUsername(QueryVo vo);

    //查询数据条数
    Integer countUser();

    //根据性别和名字查询用户
    List<User> selectUserBySexAndUsername(User user);

    //根据多个id查询用户信息
    List<User> selectUserByIds(Integer[] ids);
//    List<User> selectUserByIds(List<Integer> ids);
    List<User> selectUserByIds(QueryVo ids);
}
