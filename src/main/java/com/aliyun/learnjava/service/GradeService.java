package com.aliyun.learnjava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aliyun.learnjava.dao.GradeDao;
import com.aliyun.learnjava.entity.Grade;

@Service
public class GradeService {
    @Autowired
    private GradeDao GradeDao;

    public Grade getGrade(long id) {
        return GradeDao.getGrade(id);
    }

    public List<Grade> getGradePagination(int limit, int offset) {
        return this.GradeDao.getGradePagination(limit, offset);
    }
}
