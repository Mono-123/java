package com.aliyun.demo.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.aliyun.demo.Entity.Teacher;

public interface TeacherMapper {
    
@Select("SELECT * FROM teacher WHERE id = #{id}")
Teacher get_teacher(@Param("id") long id);

@Select("SELECT * FROM teacher LIMIT #{limit} OFFSET #{offset}")
List<Teacher> get_teacher_pag(@Param("limit") int limit, @Param("offset") int offset);

@Insert("INSERT INTO teacher (name,  gender) VALUES (#{Teacher.name}, #{Teacher.gender})")
@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
long insert_teacher(@Param("Teacher") Teacher Teacher);

@Update("UPDATE teacher SET name = #{Teacher.name} WHERE id = #{Teacher.id}")
void update_teacher(@Param("Teacher") Teacher Teacher);

@Delete("DELETE FROM teacher WHERE id = #{id}")
void delete_teacher(@Param("id") long id);
} 