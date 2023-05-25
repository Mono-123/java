package com.aliyun.demo.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aliyun.demo.Entity.Score;

public interface ScoreMapper {
    
Score getScore(@Param("id") long id);

List<Score> getScorePagination(@Param("limit") int limit, @Param("offset") int offset);

void insertScore(@Param("Score") Score Score);

void updateChinese(@Param("Score") Score Score);

void deleteScore(@Param("id") long id);
} 