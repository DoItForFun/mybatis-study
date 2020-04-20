package com.lizhe.mapper;

import com.lizhe.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    // 查询所有用户
    List<User> findUserList();
    // 根据id查询
    User findOne(int id);
    // 插入
    int addOne(User user);
    // 修改
    int updateOne(User user);
    // 删除
    int deleteOne(User user);

    // map
    int addOneMap(Map<String , Object> map);

    // 模糊查询
    List<User> findListLike(String value);
}
