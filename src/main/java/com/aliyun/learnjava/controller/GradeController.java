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

import com.aliyun.learnjava.service.GradeService;
import com.aliyun.exception.NotFoundException;
import com.aliyun.learnjava.entity.Grade;

@RestController()
@RequestMapping("grade")
public class GradeController {
    @Autowired
    private GradeService gradeService;

    @GetMapping("/list")
    public List<Grade> getGradePagination(
        @RequestParam(name = "limit", required = false, defaultValue = "10") int limit,
        @RequestParam(name = "offset", required = false, defaultValue = "0") int offset) {
        List<Grade> grade = this.gradeService.getGradePagination(10, 0);
        return grade;
    }

    @GetMapping("/{id}")
    public Grade getGrade(@PathVariable("id") long id) {
        Grade grade = this.gradeService.getGrade(id);
        return grade;
    }
    @PostMapping("")
    public Grade insertGrade(@RequestBody Grade grade) {
        return this.gradeService.inserGrade(grade);
    }

    @PutMapping("/{id}")
    public Grade updateGrade(
        @PathVariable(name = "id") int id,
        @RequestBody Grade grade
    ) throws NotFoundException {
        grade.setId(id);
        return this.gradeService.updateGrade(grade);
    }

    @PatchMapping("/{id}")
    public Grade patchGrade(
        @PathVariable(name = "id") int id,
        @RequestBody Grade grade
    ) throws NotFoundException {
        grade.setId(id);
        return this.gradeService.patchGrade(grade);
    }

    // @PutMapping("/{id}")
    // public void updateGraduated(
    // ) throws NotFoundException {
    // }

    @DeleteMapping("/{id}")
    public boolean deleteGrade(
        @PathVariable(name = "id") long id
    ) throws NotFoundException {
        return this.gradeService.deleteGrade(id);
    }
}
