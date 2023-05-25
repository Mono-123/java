package com.aliyun.demo.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aliyun.demo.Entity.Grade;

public interface GradeMapper {
    Grade getGrade(@Param("id") long id);

    List<Grade> getGradePagination(@Param("limit") int limit, @Param("offset") int offset);

    long insertGrade(@Param("Grade") Grade Grade);

    void updateGraduated();

    void updateGrade();

    void deleteGrade(@Param("id") long id);
}
