package com.aliyun.learnjava.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aliyun.learnjava.service.StudentService;
import com.aliyun.learnjava.entity.Student;

@RestController()
@RequestMapping("student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/list")
    public List<Student> getAll() {
        List<Student> students = this.studentService.getAll(10, 0);
        return students;
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable("id") long id) {
        Student student = this.studentService.getById(id);
        return student;
    }
}
