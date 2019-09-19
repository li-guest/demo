package com.example.demo.dao;

import com.example.demo.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IUserDao {

    @Select("select * from user")
    List<User> findAll();
}
