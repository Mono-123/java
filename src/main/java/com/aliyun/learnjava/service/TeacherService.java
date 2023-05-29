package com.aliyun.learnjava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aliyun.exception.NotFoundException;
import com.aliyun.learnjava.dao.TeacherDao;
import com.aliyun.learnjava.entity.Teacher;

@Service
public class TeacherService {
    @Autowired
    private TeacherDao teacherDao;

    public Teacher getTeacher(long id)throws NotFoundException {
        Teacher teacher = teacherDao.getTeacher(id);
        if (teacher == null) {
            throw new NotFoundException("id: " + id + " in teacher table not found");
        }return teacherDao.getTeacher(id);
    }

    public List<Teacher> getTeacherPagination(int limit, int offset) {
        return this.teacherDao.getTeacherPagination(limit, offset);
    }
      
    public Teacher inserTeacher(
        String  name,
        int gender
    ) {
        Teacher teacher = new Teacher();
        teacher.setName(name);
        teacher.setGender(gender);
        this.teacherDao.insertTeacher(teacher);
        return teacher;
    }

    public Teacher inserTeacher(Teacher teacher) {
        this.teacherDao.insertTeacher(teacher);
        return teacher;
    }

    public Teacher updateTeacher(Teacher teacher) throws NotFoundException {
        this.getTeacher(teacher.getId());
        this.teacherDao.updateTeacher(teacher);
        return this.getTeacher(teacher.getId());
    }

    public Teacher patchTeacher(Teacher input) throws NotFoundException {
        Teacher teacher = this.getTeacher(input.getId());
        if (teacher != null) {
            if (input.getName() != null && !input.getName().isEmpty()) {
                teacher.setName(input.getName());
            }
            if (input.getGender() != 0) {
                teacher.setGender(input.getGender());
            }
            return this.updateTeacher(teacher);
        }
        return null;
    }

    public boolean deleteTeacher(long id) throws NotFoundException {
        this.getTeacher(id);
        this.teacherDao.deleteTeacher(id);
        try {
            Teacher teacher = this.getTeacher(id);
            return teacher == null;
        } catch (NotFoundException e) {
            return true;
        }
    }
}
