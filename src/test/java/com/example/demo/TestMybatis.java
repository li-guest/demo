package com.example.demo;

import com.example.demo.dao.IUserDao;
import com.example.demo.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Author: Edward Gavin
 * @Create: 2019-09-19 10:38
 */
public class TestMybatis {
    public static void main(String[] args) throws IOException {
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        SqlSession sqlSession = factory.openSession();
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        List<User> users = userDao.findAll();
        for (User user : users){
            System.out.println(user);
        }
        System.out.println("abc");
        sqlSession.close();
        in.close();

    }
}
