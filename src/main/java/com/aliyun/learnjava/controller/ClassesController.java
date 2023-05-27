package com.aliyun.learnjava.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aliyun.learnjava.service.ClassesService;
import com.aliyun.learnjava.entity.Classes;

@RestController()
@RequestMapping("classes")
public class ClassesController {
    @Autowired
    private ClassesService classesService;

    @GetMapping("/list")
    public List<Classes> getClassesPagination() {
        List<Classes> classes = this.classesService.getClassesPagination(10, 0);
        return classes;
    }

    @GetMapping("/{id}")
    public Classes getClasses(@PathVariable("id") long id) {
        Classes classes = this.classesService.getClasses(id);
        return classes;
    }
}
