package com.aliyun.learnjava.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aliyun.learnjava.service.StudentsService;
import com.aliyun.exception.NotFoundException;
import com.aliyun.learnjava.entity.Students;

@RestController()
@RequestMapping("students")
public class StudentsController {
    @Autowired
    private StudentsService studentsService;

    @GetMapping("/list")
    public List<Students> getStudentPagination(
        @RequestParam(name = "limit", required = false, defaultValue = "10") int limit,
        @RequestParam(name = "offset", required = false, defaultValue = "0") int offset) {
        List<Students> students = this.studentsService.getStudentPagination(limit, offset);
        return students;
    }

    @GetMapping("/{id}")
    public Students getStudent(@PathVariable("id") long id) {
        Students students = this.studentsService.getStudent(id);
        return students;
    }
    @PostMapping("")
    public Students insertStudent(@RequestBody Students students) {
        return this.studentsService.inserStudent(students);
    }

    @PutMapping("/{id}")
    public Students updateClassId(
        @PathVariable(name = "id") int id,
        @RequestBody Students students
    ) throws NotFoundException {
        students.setId(id);
        return this.studentsService.updateClassId(students);
    }

    @PatchMapping("/{id}")
    public Students patchStudents(
        @PathVariable(name = "id") int id,
        @RequestBody Students students
    ) throws NotFoundException {
        students.setId(id);
        return this.studentsService.patchStudents(students);
    }

    @DeleteMapping("/{id}")
    public boolean deleteStudent(
        @PathVariable(name = "id") long id
    ) throws NotFoundException {
        return this.studentsService.deleteStudent(id);
    }
}
