package com.aliyun.learnjava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aliyun.exception.NotFoundException;
import com.aliyun.learnjava.dao.StudentDao;
import com.aliyun.learnjava.entity.Student;

@Service
public class StudentService {
    @Autowired
    private StudentDao studentDao;

    public Student getById(long id) throws NotFoundException {
        Student student = studentDao.getById(id);
        if (student == null) {
            throw new NotFoundException("id: " + id + " in student table not found");
        }
        return student;
    }

    public List<Student> getBy(String condition, String query) throws NotFoundException {
        List<Student> student = studentDao.getBy(condition, query);
        if (student == null) {
            throw new NotFoundException(condition + ":" + query + " in student table not found");
        }
        return student;
    }

    public List<Student> getCondition(String name, String gender, String grade, String score) throws NotFoundException {
        List<Student> student = studentDao.getCondition(name, gender, grade, score);
        if (student == null) {
            throw new NotFoundException("name: " + name + "gender: " + gender + "grade: " + grade + "score: " + score
                    + " in student table not found");
        }
        return student;
    }

    public List<Student> getAll(String gender, String order, int desc, Integer limit, Integer offset) {
        return this.studentDao.getAll(gender, order, desc, limit, offset);
    }

    public Integer getTotal() {
        return this.studentDao.getTotal();
    }

    public Student inserStudent(
            String name,
            Integer gender,
            Integer grade,
            Integer score,
            String img) {
        Student stu = new Student();
        stu.setName(name);
        stu.setGender(gender);
        stu.setGrade(grade);
        stu.setScore(score);
        stu.setImg(img);
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

    public Student updateStudent(Student student) throws NotFoundException {
        this.getById(student.getId());
        this.studentDao.updateById(student);
        return this.getById(student.getId());
    }

    public Student patchStudent(Student input) throws NotFoundException {
        Student student = this.getById(input.getId());
        if (student != null) {
            if (input.getName() != null && !input.getName().isEmpty()) {
                student.setName(input.getName());
            }
            if (input.getGender() == null) {
                student.setGender(input.getGender());
            }
            if (input.getGrade() == null) {
                student.setGrade(input.getGrade());
            }
            if (input.getScore() == null) {
                student.setScore(input.getScore());
            }
            return this.updateStudent(student);
        }
        return null;
    }

    public boolean deleteStudent(long id) throws NotFoundException {
        this.getById(id);
        this.studentDao.deleteById(id);
        try {
            Student student = this.getById(id);
            return student == null;
        } catch (NotFoundException e) {
            return true;
        }
    }
}
