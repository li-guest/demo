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
 * 入门案例
 * @Author: Edward Gavin
 * @Create: 2019-09-19 10:38
 */
public class TestMybatis {
    public static void main(String[] args) throws IOException {
        //1. 读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2. 使用
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //3. 使用工厂生成sqlsession对象
        SqlSessionFactory factory = builder.build(in);
        //4. 使用动态代理
        SqlSession sqlSession = factory.openSession();
        sqlSession.se


        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        List<User> users = userDao.findAll();
        for (User user : users){
            System.out.println(user);
        }
        sqlSession.close();
        in.close();

    }
}
