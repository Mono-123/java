package com.aliyun.learnjava.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aliyun.learnjava.service.ScoreService;
import com.aliyun.learnjava.entity.Score;

@RestController()
@RequestMapping("Score")
public class ScoreController {
    @Autowired
    private ScoreService ScoreService;

    @GetMapping("/list")
    public List<Score> getScorePagination() {
        List<Score> Score = this.ScoreService.getScorePagination(10, 0);
        return Score;
    }

    @GetMapping("/{id}")
    public Score getScore(@PathVariable("id") long id) {
        Score Score = this.ScoreService.getScore(id);
        return Score;
    }
}
