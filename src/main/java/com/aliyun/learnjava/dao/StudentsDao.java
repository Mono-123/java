package com.aliyun.learnjava.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aliyun.learnjava.entity.Students;

public interface StudentsDao {
	Students getStudent(@Param("id") long id);

    List<Students> getStudentPagination(@Param("limit") int limit, @Param("offset") int offset);
 
    void insertStudent(@Param("student") Students students);
   
    void updateClassId(@Param("student") Students students);

    void deleteStudent(@Param("id") long id);
}
