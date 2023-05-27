package com.aliyun.learnjava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aliyun.learnjava.dao.TeacherDao;
import com.aliyun.learnjava.entity.Teacher;

@Service
public class TeacherService {
    @Autowired
    private TeacherDao TeacherDao;

    public Teacher getTeacher(long id) {
        return TeacherDao.getTeacher(id);
    }

    public List<Teacher> getTeacherPagination(int limit, int offset) {
        return this.TeacherDao.getTeacherPagination(limit, offset);
    }
}
