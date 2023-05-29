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

import com.aliyun.learnjava.service.TeacherService;
import com.aliyun.exception.NotFoundException;
import com.aliyun.learnjava.entity.Teacher;

@RestController()
@RequestMapping("teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @GetMapping("/list")
    public List<Teacher> getTeacherPagination(
        @RequestParam(name = "limit", required = false, defaultValue = "10") int limit,
        @RequestParam(name = "offset", required = false, defaultValue = "0") int offset) {
        List<Teacher> teacher = this.teacherService.getTeacherPagination(10, 0);
        return teacher;
    }

    @GetMapping("/{id}")
    public Teacher getTeacher(@PathVariable("id") long id) {
        Teacher teacher = this.teacherService.getTeacher(id);
        return teacher;
    }
    @PostMapping("")
    public Teacher insertTeacher(@RequestBody Teacher teacher) {
        return this.teacherService.inserTeacher(teacher);
    }

    @PutMapping("/{id}")
    public Teacher updateTeacher(
        @PathVariable(name = "id") int id,
        @RequestBody Teacher teacher
    ) throws NotFoundException {
        teacher.setId(id);
        return this.teacherService.updateTeacher(teacher);
    }

    @PatchMapping("/{id}")
    public Teacher patchTeacher(
        @PathVariable(name = "id") int id,
        @RequestBody Teacher teacher
    ) throws NotFoundException {
        teacher.setId(id);
        return this.teacherService.patchTeacher(teacher);
    }

    @DeleteMapping("/{id}")
    public boolean deleteTeacher(
        @PathVariable(name = "id") long id
    ) throws NotFoundException {
        return this.teacherService.deleteTeacher(id);
    }
}
