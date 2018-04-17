package com.demo.mapper;

import com.demo.entity.User;

public interface UserMapper {
    User selectUserById(Integer id);
}
