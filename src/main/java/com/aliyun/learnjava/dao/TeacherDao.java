package com.aliyun.learnjava.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aliyun.learnjava.entity.Teacher;

public interface TeacherDao {
    Teacher getTeacher(@Param("id") long id);

    List<Teacher> getTeacherPagination(@Param("limit") int limit, @Param("offset") int offset);

    void insertTeacher(@Param("Teacher") Teacher Teacher);

    void updateTeacher(@Param("Teacher") Teacher Teacher);

    void deleteTeacher(@Param("id") long id);
}