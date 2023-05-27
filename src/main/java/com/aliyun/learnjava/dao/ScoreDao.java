package com.aliyun.learnjava.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aliyun.learnjava.entity.Score;

public interface ScoreDao {

    Score getScore(@Param("id") long id);

    List<Score> getScorePagination(@Param("limit") int limit, @Param("offset") int offset);

    void insertScore(@Param("Score") Score Score);

    void updateChinese(@Param("Score") Score Score);

    void deleteScore(@Param("id") long id);
}