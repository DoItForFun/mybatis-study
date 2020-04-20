package com.thr.mapper;

import com.thr.pro.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> getAllUsers();
    List<User> getUserLimit(Map<String,Integer> map);
    List<User> getUserRowBounds();
}
