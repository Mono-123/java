package com.aliyun.demo.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.aliyun.demo.Entity.Grade;

public interface GradeMapper {
    @Select("SELECT * FROM grade WHERE id = #{id}")
	Grade get_grade(@Param("id") long id);
    
    @Select("SELECT * FROM grade LIMIT #{limit} OFFSET #{offset}")
    List<Grade> get_grade_paging(@Param("limit") int limit, @Param("offset") int offset);

    @Insert("INSERT INTO grade (grade, manager_id, is_graduated) VALUES (#{Grade.grade}, #{Grade.manager_id}, #{Grade.is_graduated})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    long insert_grade(@Param("Grade") Grade Grade);

    @Update("UPDATE grade SET is_graduated = 1 WHERE grade = 4 ")
    void update_graduated();

    
    @Update("UPDATE grade SET grade = grade + 1 WHERE grade<4 ")
    void update_grade();

    @Delete("DELETE FROM grade WHERE id = #{id}")
    void delete_grade(@Param("id") long id);
}

