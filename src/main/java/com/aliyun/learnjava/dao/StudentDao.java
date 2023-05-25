package com.aliyun.learnjava.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aliyun.learnjava.entity.Student;
public interface StudentDao {
    Student getById(@Param("id") long id);
    
    List<Student> getAll(@Param("limit") int limit, @Param("offset") int offset);

    void insert(@Param("stu") Student student);

    void updateScore(@Param("stu")Student student);

    void deleteById(@Param("id") long id);
}   