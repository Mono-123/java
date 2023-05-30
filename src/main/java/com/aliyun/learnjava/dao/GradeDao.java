package com.aliyun.learnjava.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aliyun.learnjava.entity.Grade;

public interface GradeDao {
    Grade getGrade(@Param("id") long id);

    List<Grade> getGradePagination(@Param("limit") int limit, @Param("offset") int offset);

    List<Grade> getGraduate();

    void insertGrade(@Param("grade") Grade grade);

    void updateGraduate();

    void updateGrade(@Param("grade") Grade grade);

    void deleteGrade(@Param("id") long id);
}
