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
@RequestMapping("score")
public class ScoreController {
    @Autowired
    private ScoreService scoreService;

    @GetMapping("/list")
    public List<Score> getScorePagination() {
        List<Score> score = this.scoreService.getScorePagination(10, 0);
        return score;
    }

    @GetMapping("/{id}")
    public Score getScore(@PathVariable("id") long id) {
        Score score = this.scoreService.getScore(id);
        return score;
    }
}
