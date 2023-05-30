package com.aliyun.learnjava.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aliyun.learnjava.entity.Classes;

public interface ClassesDao {
    Classes getClasses(@Param("id") long id);

    List<Classes> getClassesPagination(@Param("limit") int limit, @Param("offset") int offset);

    long insertClasses(@Param("classes") Classes classes);

    void updateClasses(@Param("classes") Classes classes);

    void deleteClasses(@Param("id") long id);
}
