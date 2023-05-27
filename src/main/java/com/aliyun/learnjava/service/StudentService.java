package com.aliyun.learnjava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aliyun.learnjava.dao.StudentDao;
import com.aliyun.learnjava.entity.Student;

@Service
public class StudentService {
    @Autowired
    private StudentDao studentDao;

    public Student getById(long id) {
        return studentDao.getById(id);
    }

    public List<Student> getAll(int limit, int offset) {
        return this.studentDao.getAll(limit, offset);
    }

    public Student inserStudent(
        String name,
        int gender,
        int grade,
        int score
    ) {
        Student stu = new Student();
        stu.setName(name);
        stu.setGender(gender);
        stu.setGrade(grade);
        stu.setScore(score);
        this.studentDao.insert(stu);
        return stu;
    }

    public Student inserStudent(Student student) {
        if (student.getName() == null || student.getName().isEmpty()) {
            student.setName("unamed");
        }
        this.studentDao.insert(student);
        return student;
    }

    public Student updateStudent(Student student) {
        this.studentDao.updateById(student);
        return this.studentDao.getById(student.getId());
    }

    public Student patchStudent(Student input) {
        Student student = this.studentDao.getById(input.getId());
        if (student != null) {
            if (input.getName() != null && !input.getName().isEmpty()) {
                student.setName(input.getName());
            }
            if (input.getGender() != 0) {
                student.setGender(input.getGender());
            }
            if (input.getGrade() != 0) {
                student.setGrade(input.getGrade());
            }
            if (input.getScore() != 0) {
                student.setScore(input.getScore());
            }
            return this.updateStudent(student);
        }
        return null;
    }
}
