package com.aliyun.learnjava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aliyun.learnjava.dao.ClassesDao;
import com.aliyun.learnjava.entity.Classes;

@Service
public class ClassesService {
    @Autowired
    private ClassesDao ClassesDao;

    public Classes getClasses(long id) {
        return ClassesDao.getClasses(id);
    }

    public List<Classes> getClassesPagination(int limit, int offset) {
        return this.ClassesDao.getClassesPagination(limit, offset);
    }
}
