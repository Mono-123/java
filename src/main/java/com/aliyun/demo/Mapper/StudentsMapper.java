package com.aliyun.demo.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.aliyun.demo.Entity.Students;

public interface StudentsMapper {
    @Select("SELECT * FROM student WHERE id = #{id}")
	Students get_student(@Param("id") long id);
    
    @Select("SELECT * FROM student LIMIT #{limit} OFFSET #{offset}")
    List<Students> get_student_paging(@Param("limit") int limit, @Param("offset") int offset);

    @Insert("INSERT INTO student (name, gender, class_id) VALUES (#{student.name}, #{student.gender}, #{student.class_id})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    long insert_student(@Param("student") Students students);

    @Update("UPDATE student SET class_id = #{student.class_id} WHERE id = #{student.id}")
    void updateclass_id(@Param("student") Students students);

    @Delete("DELETE FROM student WHERE id = #{id}")
    void deletestudent(@Param("id") long id);
}
