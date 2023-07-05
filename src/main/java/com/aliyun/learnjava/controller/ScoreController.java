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

import com.aliyun.learnjava.service.ScoreService;
import com.aliyun.exception.NotFoundException;
import com.aliyun.learnjava.entity.Score;

@RestController()
@RequestMapping("score")
public class ScoreController {
    @Autowired
    private ScoreService scoreService;

    @GetMapping("/list")
    public List<Score> getScorePagination(
        @RequestParam(name = "order", required = false, defaultValue = "chinese") String order,
        @RequestParam(name = "limit", required = false, defaultValue = "10") int limit,
        @RequestParam(name = "offset", required = false, defaultValue = "0") int offset) {
        List<Score> score = this.scoreService.getScorePagination(order,limit, offset);
        return score;
    }

    @GetMapping("/{id}")
    public Score getScore(@PathVariable("id") long id) {
        Score score = this.scoreService.getScore(id);
        return score;
    }

    @PostMapping("")
    public Score insertScore(@RequestBody Score score) {
        return this.scoreService.inserScore(score);
    }

    @PutMapping("/{id}")
    public Score updateChinese(
        @PathVariable(name = "id") int id,
        @RequestBody Score score
    ) throws NotFoundException {
        score.setId(id);
        return this.scoreService.updateChinese(score);
    }

    @PatchMapping("/{id}")
    public Score patchScore(
        @PathVariable(name = "id") int id,
        @RequestBody Score score
    ) throws NotFoundException {
        score.setId(id);
        return this.scoreService.patchScore(score);
    }

    @DeleteMapping("/{id}")
    public boolean deleteScore(
        @PathVariable(name = "id") long id
    ) throws NotFoundException {
        return this.scoreService.deleteScore(id);
    }
}
