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

import com.aliyun.learnjava.service.StudentService;
import com.aliyun.exception.NotFoundException;
import com.aliyun.learnjava.entity.Student;

@RestController()
@RequestMapping("student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/list")
    public List<Student> getAll(
            @RequestParam(name = "limit", required = false, defaultValue = "10") int limit,
            @RequestParam(name = "offset", required = false, defaultValue = "0") int offset,
            @RequestParam(name = "order", required = false, defaultValue = "id") String order) {
        List<Student> students = this.studentService.getAll(limit, offset, order);
        return students;
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable("id") long id) throws NotFoundException {
        Student student = this.studentService.getById(id);
        return student;
    }

    @PostMapping("")
    public Student insert(@RequestBody Student student) {
        return this.studentService.inserStudent(student);
    }

    @PutMapping("/{id}")
    public Student updateById(
            @PathVariable(name = "id") int id,
            @RequestBody Student student) throws NotFoundException {
        student.setId(id);
        return this.studentService.updateStudent(student);
    }

    @PatchMapping("/{id}")
    public Student patchById(
            @PathVariable(name = "id") int id,
            @RequestBody Student student) throws NotFoundException {
        student.setId(id);
        return this.studentService.patchStudent(student);
    }

    @DeleteMapping("/{id}")
    public boolean deleteById(
            @PathVariable(name = "id") long id) throws NotFoundException {
        return this.studentService.deleteStudent(id);
    }
}
