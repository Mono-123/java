package com.aliyun.demo.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.aliyun.demo.Entity.Score;

public interface ScoreMapper {
    
@Select("SELECT * FROM score WHERE id = #{id}")
Score get_score(@Param("id") long id);

@Select("SELECT * FROM score LIMIT #{limit} OFFSET #{offset}")
List<Score> get_score_paging(@Param("limit") int limit, @Param("offset") int offset);

@Insert("INSERT INTO score (student_id,chinese,math,english) VALUES (#{Score.student_id}, #{Score.chinese},#{Score.math},#{Score.english})")
@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
long insert_score(@Param("Score") Score Score);

@Update("UPDATE score SET chinese = #{Score.chinese} WHERE id = #{Score.id}")
void update_score(@Param("Score") Score Score);

@Delete("DELETE FROM score WHERE id = #{id}")
void delete_score(@Param("id") long id);
} 