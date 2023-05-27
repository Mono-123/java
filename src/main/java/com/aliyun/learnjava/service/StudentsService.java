package com.aliyun.learnjava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aliyun.learnjava.dao.StudentsDao;
import com.aliyun.learnjava.entity.Students;

@Service
public class StudentsService {
    @Autowired
    private StudentsDao studentsDao;

    public Students getStudent(long id) {
        return studentsDao.getStudent(id);
    }

    public List<Students> getStudentPagination(int limit, int offset) {
        return this.studentsDao.getStudentPagination(limit, offset);
    }
}
