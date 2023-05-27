package com.aliyun.learnjava.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aliyun.learnjava.service.TeacherService;
import com.aliyun.learnjava.entity.Teacher;

@RestController()
@RequestMapping("Teacher")
public class TeacherController {
    @Autowired
    private TeacherService TeacherService;

    @GetMapping("/list")
    public List<Teacher> getTeacherPagination() {
        List<Teacher> Teacher = this.TeacherService.getTeacherPagination(10, 0);
        return Teacher;
    }

    @GetMapping("/{id}")
    public Teacher getTeacher(@PathVariable("id") long id) {
        Teacher Teacher = this.TeacherService.getTeacher(id);
        return Teacher;
    }
}
