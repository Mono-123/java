package com.aliyun.demo.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aliyun.demo.Entity.Classes;

public interface ClassesMapper {
    Classes getClasses(@Param("id") long id);

    List<Classes> getClassesPagination(@Param("limit") int limit, @Param("offset") int offset);

    long insertClasses(@Param("classes") Classes Classes);

    void updateClassesManager(@Param("classes") Classes Classes);

    void updateGrade(@Param("classes") int is_grade);

    void deleteClasses(@Param("id") long id);
}
