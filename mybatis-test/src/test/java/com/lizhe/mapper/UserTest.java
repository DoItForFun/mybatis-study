package com.lizhe.mapper;

import com.lizhe.pojo.User;
import com.lizhe.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserTest {
    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.findUserList();
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }
    @Test
    public void findOne(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.findOne(1);
        System.out.println(user);
        sqlSession.close();
    }
    @Test
    public void addOne(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int result = userMapper.addOne(new User(5,"zzz","kkk"));
        if(result > 0){
            // 提交事务
            sqlSession.commit();
        }
        sqlSession.close();
    }
    @Test
    public void updateOne(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(4);
        user.setName("lz");
        int res = userMapper.updateOne(user);
        if (res > 0){
            sqlSession.commit();
        }
        sqlSession.close();
    }
    @Test
    public void delOne(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User Obj = new User();
        Obj.setName("sss");
        userMapper.deleteOne(Obj);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void addOneMap(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Map map = new HashMap<String , Object> ();
        map.put("userid" , 5);
        map.put("username" , "lizzz");
        map.put("password" , "sdf");
        userMapper.addOneMap(map);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void findListLike(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.findListLike("%李%");
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }

}
