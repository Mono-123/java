package com.aliyun.learnjava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aliyun.exception.NotFoundException;
import com.aliyun.learnjava.dao.StudentsDao;
import com.aliyun.learnjava.entity.Students;

@Service
public class StudentsService {
    @Autowired
    private StudentsDao studentsDao;

    public Students getStudent(long id)throws NotFoundException {
        Students students = studentsDao.getStudent(id);
        if (students == null) {
            throw new NotFoundException("id: " + id + " in students table not found");
        }
        return studentsDao.getStudent(id);
    }

    public List<Students> getStudentPagination(int limit, int offset) {
        return this.studentsDao.getStudentPagination(limit, offset);
    }

    public Students inserStudents(
        String  name,
        int managerId,
        int gradeId
    ) {
        Students students = new Students();
        students.setName(name);
        students.setManagerId(managerId);
        students.setGradeId(gradeId);
        this.studentsDao.insertStudent(students);
        return students;
    }

    public Students inserStudent(Students students) {
        this.studentsDao.insertStudent(students);
        return students;
    }

    public Students updateClassId(Students students) throws NotFoundException {
        this.getStudent(students.getId());
        this.studentsDao.updateClassId(students);
        return this.getStudent(students.getId());
    }
 
    public Students patchStudents(Students input) throws NotFoundException {
        Students students = this.getStudent(input.getId());
        if (students != null) {
            if (input.getName() != null && !input.getName().isEmpty()) {
                students.setName(input.getName());
            }
            if (input.getManagerId() != 0) {
                students.setManagerId(input.getManagerId());
            }
            if (input.getGradeId() != 0) {
                students.setGradeId(input.getGradeId());
            }
        
            return this.updateClassId(students);
        }
        return null;
    }

    public boolean deleteStudent(long id) throws NotFoundException {
        this.getStudent(id);
        this.studentsDao.deleteStudent(id);
        try {
            Students students = this.getStudent(id);
            return students == null;
        } catch (NotFoundException e) {
            return true;
        }
    }
}
