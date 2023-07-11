package com.aliyun.learnjava.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aliyun.learnjava.entity.Student;

public interface StudentDao {
        Student getById(@Param("id") long id);

        List<Student> getBy(@Param("condition") String condition, @Param("query") String query);

        List<Student> getAll(@Param("gender") String gender,
                        @Param("order") String order, @Param("desc") int desc,
                        @Param("limit") int limit, @Param("offset") int offset);

        Integer getTotal();

        List<Student> getCondition(
                        @Param("name") String name, @Param("gender") String gender,
                        @Param("grade") String grade, @Param("score") String score);

        void insert(@Param("stu") Student student);

        void updateById(@Param("stu") Student student);

        void deleteById(@Param("id") long id);
}