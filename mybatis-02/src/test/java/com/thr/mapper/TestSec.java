package com.thr.mapper;

import com.thr.pro.User;
import com.thr.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TestSec {
    @Test
    public void getAllUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.getAllUsers();
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }
}
