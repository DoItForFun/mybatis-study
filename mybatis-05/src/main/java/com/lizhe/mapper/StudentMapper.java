package com.lizhe.mapper;

import com.lizhe.dao.Student;

import java.util.List;

public interface StudentMapper {
    List<Student> getStudentList();

    List<Student> getStudentSet();
}
