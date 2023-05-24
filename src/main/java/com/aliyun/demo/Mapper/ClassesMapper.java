package com.aliyun.demo.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.aliyun.demo.Entity.Classes;

public interface ClassesMapper {
    @Select("SELECT * FROM classes WHERE id = #{id}")
	Classes get_classes(@Param("id") long id);
    
    @Select("SELECT * FROM classes LIMIT #{limit} OFFSET #{offset}")
    List<Classes> get_classes_paging(@Param("limit") int limit, @Param("offset") int offset);

    @Insert("INSERT INTO classes (name, manager_id, grade_id) VALUES (#{classes.name}, #{classes.manager_id}, #{classes.grade_id})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    long insert_classes(@Param("classes") Classes Classes);

    @Update("UPDATE classes SET manager_id = #{classes.manager_id} WHERE id = #{classes.id}")
    void update_classes_manager(@Param("classes") Classes Classes);

    @Update("UPDATE classes SET grade_id = #{classes.grade_id}")
    void update_grade(@Param("classes") int is_grade);

    @Delete("DELETE FROM classes WHERE id = #{id}")
    void delete_classes(@Param("id") long id);
}
