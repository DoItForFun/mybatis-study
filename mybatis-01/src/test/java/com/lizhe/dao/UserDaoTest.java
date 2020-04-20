package com.lizhe.dao;

import com.lizhe.pojo.User;
import com.lizhe.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {
    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try  {
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            List <User> userList = userDao.getUserList();
            for (User user : userList) {
                System.out.println(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            sqlSession.close();
        }
    }
}
