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

import com.aliyun.learnjava.service.ClassesService;
import com.aliyun.exception.NotFoundException;
import com.aliyun.learnjava.entity.Classes;

@RestController()
@RequestMapping("classes")
public class ClassesController {
    @Autowired
    private ClassesService classesService;

    @GetMapping("/list")
    public List<Classes> getClassesPagination(
        @RequestParam(name = "limit", required = false, defaultValue = "10") int limit,
        @RequestParam(name = "offset", required = false, defaultValue = "0") int offset) {
        List<Classes> classes = this.classesService.getClassesPagination(10, 0);
        return classes;
    }

    @GetMapping("/{id}")
    public Classes getClasses(@PathVariable("id") long id) {
        Classes classes = this.classesService.getClasses(id);
        return classes;
    }
    @PostMapping("")
    public Classes insertClasses(@RequestBody Classes classes) {
        return this.classesService.inserClasses(classes);
    }

    @PutMapping("/{id}")
    public Classes updateClasses(
        @PathVariable(name = "id") int id,
        @RequestBody Classes classes
    ) throws NotFoundException {
        classes.setId(id);
        return this.classesService.updateClasses(classes);
    }

    @PatchMapping("/{id}")
    public Classes patchClasses(
        @PathVariable(name = "id") int id,
        @RequestBody Classes classes
    ) throws NotFoundException {
        classes.setId(id);
        return this.classesService.patchClasses(classes);
    }

    @DeleteMapping("/{id}")
    public boolean deleteClasses(
        @PathVariable(name = "id") long id
    ) throws NotFoundException {
        return this.classesService.deleteClasses(id);
    }
}
