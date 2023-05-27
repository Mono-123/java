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
@RequestMapping("Classes")
public class ClassesController {
    @Autowired
    private ClassesService ClassesService;

    @GetMapping("/list")
    public List<Classes> getClassesPagination() {
        List<Classes> Classes = this.ClassesService.getClassesPagination(10, 0);
        return Classes;
    }

    @GetMapping("/{id}")
    public Classes getClasses(@PathVariable("id") long id) {
        Classes Classes = this.ClassesService.getClasses(id);
        return Classes;
    }
}
