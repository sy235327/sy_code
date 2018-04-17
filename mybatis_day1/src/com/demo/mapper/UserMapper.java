package com.demo.mapper;

import com.demo.mybatis1.entity.User;

public interface UserMapper {
    /**
     * 自动生成dao垃圾代码
     * 遵循四个原则
     * 第一个: 接口方法名 == Mapper.xml(User.xml)中id名
     * 第二个: 接口返回值类型与Mapper.xml文件中返回值类型一致
     * 第三个: 方法的入参类型(方法参数类型)与Mapper.xml中入参要一致
     * 第四个: Mapper.xml中的命名空间绑定接口
     */
    public User findUserById(Integer id);

}
