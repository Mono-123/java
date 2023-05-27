package com.aliyun.learnjava.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aliyun.learnjava.service.GradeService;
import com.aliyun.learnjava.entity.Grade;

@RestController()
@RequestMapping("grade")
public class GradeController {
    @Autowired
    private GradeService gradeService;

    @GetMapping("/list")
    public List<Grade> getGradePagination() {
        List<Grade> grade = this.gradeService.getGradePagination(10, 0);
        return grade;
    }

    @GetMapping("/{id}")
    public Grade getGrade(@PathVariable("id") long id) {
        Grade grade = this.gradeService.getGrade(id);
        return grade;
    }
}
