package com.fou.mapper;



import com.fou.modle.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    @Select("select * from user")
    List<User> getAllUser();

    @Select("select * from user where id=#{id}")
    User getUserByParam(int id);
    @Insert("insert into user(id,name,pwd) values(#{id} , #{userName} , #{password})")
    void addUser(User user);
    @Update("update user set name=#{userName},pwd=#{password} where id=#{id}")
    int updateUser(User user);
    @Delete("delete from user where id=#{userId}")
    int deleteUser(int uid);
}
