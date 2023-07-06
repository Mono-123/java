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
            @RequestParam(name = "order", required = false, defaultValue = "score") String order,
            @RequestParam(name = "desc", required = false, defaultValue = "0") int desc,
            @RequestParam(name = "limit", required = false, defaultValue = "10") int limit,
            @RequestParam(name = "offset", required = false, defaultValue = "0") int offset) {
        List<Student> students = this.studentService.getAll(order,desc, limit, offset);
        return students;
    }

    @GetMapping("/{condition}/{query}")
    public List<Student> getBy(
            @PathVariable("condition") String condition,
            @PathVariable("query") String query) throws NotFoundException {
        System.out.println("condition: " + condition + "query: " + query);
        List<Student> students = this.studentService.getBy(condition, query);
        return students;
    }

    @GetMapping("/condition")
    public List<Student> getCondition(
            @RequestParam(name = "name" ,required = false) String name,
            @RequestParam(name = "gender" ,required = false) String gender,
            @RequestParam(name = "grade" ,required = false) String grade,
            @RequestParam(name = "score" ,required = false) String score) throws NotFoundException {
        System.out.println("name: " + name + "gender: " + gender + "grade: " + grade + "score: " + score);
        List<Student> students = this.studentService.getCondition(name, gender,grade,score);
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
