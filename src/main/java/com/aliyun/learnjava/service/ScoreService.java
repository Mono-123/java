package com.aliyun.learnjava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aliyun.exception.NotFoundException;
import com.aliyun.learnjava.dao.ScoreDao;
import com.aliyun.learnjava.entity.Score;

@Service
public class ScoreService {
    @Autowired
    private ScoreDao scoreDao;

    public Score getScore(long id)throws NotFoundException {
        Score score = scoreDao.getScore(id);
        if (score == null) {
            throw new NotFoundException("id: " + id + " in score table not found");
        }
        return scoreDao.getScore(id);
    }

    public List<Score> getScorePagination(String order,int desc,int limit, int offset) {
        return this.scoreDao.getScorePagination( order,desc,limit, offset);
    }
    
    public Score inserScore(
        int  studentId,
        int chinese,
        int math,
        int english
    ) {
        Score score = new Score();
        score.setStudentId(studentId);
        score.setChinese(chinese);
        score.setMath(math);
        score.setEnglish(english);
        this.scoreDao.insertScore(score);
        return score;
    }

    public Score inserScore(Score score) {
        this.scoreDao.insertScore(score);
        return score;
    }

    public Score updateChinese(Score score) throws NotFoundException {
        this.getScore(score.getId());
        this.scoreDao.updateChinese(score);
        return this.getScore(score.getId());
    }

    public Score patchScore(Score input) throws NotFoundException {
        Score score = this.getScore(input.getId());
        if (score != null) {
            if (input.getStudentId() != 0) {
                score.setStudentId(input.getStudentId());
            }
            if (input.getChinese() != 0) {
                score.setChinese(input.getChinese());
            }
            if (input.getMath() != 0) {
                score.setMath(input.getMath());
            }
            if (input.getEnglish() != 0) {
                score.setEnglish(input.getEnglish());
            }
            return this.updateChinese(score);
        }
        return null;
    }

    public boolean deleteScore(long id) throws NotFoundException {
        this.getScore(id);
        this.scoreDao.deleteScore(id);
        try {
            Score score = this.getScore(id);
            return score == null;
        } catch (NotFoundException e) {
            return true;
        }
    }
}
