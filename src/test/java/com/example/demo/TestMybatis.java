package com.example.demo;

import com.example.demo.dao.ITaskDao;
import com.example.demo.dao.IUserDao;
import com.example.demo.domain.Task;
import com.example.demo.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

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
        testTack();
        // testUser();
    }

    @Test
    public static void testTack() throws IOException {
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        SqlSession sqlSession = factory.openSession();
        ITaskDao taskDao = sqlSession.getMapper(ITaskDao.class);
        List<Task> tasks = taskDao.findAll();
        for (Task task : tasks) {
            System.out.println(task);
        }
        sqlSession.close();
        in.close();
    }

    @Test
    public static void testUser() throws IOException {
        //1. 读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2. 使用
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //3. 使用工厂生成sqlsession对象   // 使用了构建者模式，把对象的创建细节隐藏，使得使用者直接调用方法即可以拿到对象。
        SqlSessionFactory factory = builder.build(in);
        //4. 使用动态代理  // 生产SqlSession使用了工厂模式，
        SqlSession sqlSession = factory.openSession();
        // 创建Dao接口实现类，使用了代理模式，指的是，在不修改源码的基础上，对已有方法增强
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        List<User> users = userDao.findAll();
        for (User user : users){
            System.out.println(user);
        }
        sqlSession.close();
        in.close();
    }
}
