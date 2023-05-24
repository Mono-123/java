package com.aliyun.demo.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aliyun.demo.Entity.Student;
import com.aliyun.demo.Util.Pagination;

public interface StudentMapper {
	Student getById(@Param("id") long id);
    
    List<Student> getAll(@Param("limit") int limit, @Param("offset") int offset);
    
    List<Student> getAllByPagination(@Param("page") Pagination pagination);

    void insert(@Param("stu") Student student);

    void updateScore(@Param("stu")Student student);

    void deleteById(@Param("id") long id);
}
