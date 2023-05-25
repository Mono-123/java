package com.aliyun.demo.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aliyun.demo.Entity.Teacher;

public interface TeacherMapper {
    
Teacher getTeacher(@Param("id") long id);

List<Teacher> getTeacherPagination(@Param("limit") int limit, @Param("offset") int offset);

void insertTeacher(@Param("Teacher") Teacher Teacher);

void updateTeacher(@Param("Teacher") Teacher Teacher);

void deleteTeacher(@Param("id") long id);
} 