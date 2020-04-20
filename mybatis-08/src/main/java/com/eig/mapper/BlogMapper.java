package com.eig.mapper;

import com.eig.dao.Blog;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface BlogMapper {
    void insertBlog(Blog blog);

    List<Blog> getBlog(Map<String , String> map);

    List<Blog> getBlogById(Map<String , ArrayList<String>> map);

    void updateBlog(Map<String , String> map);

    List<Blog> getBlogByChoose(Map<String , String> map);
}
