package com.fou.mapper;

import com.fou.com.fou.utils.MyBatisUtils;
import com.fou.modle.User;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserTest {
    @Test
    public void getAllUser(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.getAllUser();
        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();
    }


    @Test
    public  void getUserLimit2(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        RowBounds rowBounds = new RowBounds(0,3);
        List<User> users = sqlSession.selectList("com.fou.mapper.UserMapper.getAllUser" , null , rowBounds);
        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void getUserByParam(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserByParam(2);
        System.out.println(user);
    }

    @Test
    public void addUser(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession(true);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(9,"joker1" , "1123s33");
        userMapper.addUser(user);
        sqlSession.close();
    }
    @Test
    public void updateUser(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession(true);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(7,"zzz" ,"lsdf");
        userMapper.updateUser(user);
        sqlSession.close();
    }
    @Test
    public void deleteUser(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession(true);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.deleteUser(7);
        sqlSession.close();
    }
}
