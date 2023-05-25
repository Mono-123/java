package com.aliyun.demo.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aliyun.demo.Entity.Students;

public interface StudentsMapper {
	Students getStudent(@Param("id") long id);

    List<Students> getStudentPagination(@Param("limit") int limit, @Param("offset") int offset);
 
    void insertStudent(@Param("student") Students students);
   
    void updateClassId(@Param("student") Students students);

    void deleteStudent(@Param("id") long id);
}
