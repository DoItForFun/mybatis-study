package com.se.mapper;

import com.se.dao.Teacher;

import java.util.List;

public interface TeacherMapper {
    List<Teacher> getTeacherInfo(int tid);

    List<Teacher> getTeacherList(int id);
}
