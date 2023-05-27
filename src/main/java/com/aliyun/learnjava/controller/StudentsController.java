package com.aliyun.learnjava.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aliyun.learnjava.service.StudentsService;
import com.aliyun.learnjava.entity.Students;

@RestController()
@RequestMapping("students")
public class StudentsController {
    @Autowired
    private StudentsService studentsService;

    @GetMapping("/list")
    public List<Students> getStudentPagination() {
        List<Students> students = this.studentsService.getStudentPagination(10, 0);
        return students;
    }

    @GetMapping("/{id}")
    public Students getStudent(@PathVariable("id") long id) {
        Students students = this.studentsService.getStudent(id);
        return students;
    }
}
