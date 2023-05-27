package com.aliyun.learnjava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aliyun.learnjava.dao.ScoreDao;
import com.aliyun.learnjava.entity.Score;

@Service
public class ScoreService {
    @Autowired
    private ScoreDao ScoreDao;

    public Score getScore(long id) {
        return ScoreDao.getScore(id);
    }

    public List<Score> getScorePagination(int limit, int offset) {
        return this.ScoreDao.getScorePagination(limit, offset);
    }
}
