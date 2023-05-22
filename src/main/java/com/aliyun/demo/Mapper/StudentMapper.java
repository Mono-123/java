package com.aliyun.demo.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.aliyun.demo.Entity.Student;

public interface StudentMapper {
    @Select("SELECT * FROM students WHERE id = #{id}")
	Student getById(@Param("id") long id);
    
    @Select("SELECT * FROM students LIMIT #{limit} OFFSET #{offset}")
    List<Student> getAll(@Param("limit") int limit, @Param("offset") int offset);

    @Insert("INSERT INTO students (name, gender, grade, score) VALUES (#{stu.name}, #{stu.gender}, #{stu.grade}, #{stu.score})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void insert(@Param("stu") Student student);

    @Update("UPDATE students SET score = #{stu.score} WHERE id = #{stu.id}")
    void updateScore(@Param("stu") Student student);

    @Delete("DELETE FROM students WHERE id = #{id}")
    void deleteById(@Param("id") long id);
}
