package com.aliyun.learnjava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aliyun.exception.NotFoundException;
import com.aliyun.learnjava.dao.ClassesDao;
import com.aliyun.learnjava.entity.Classes;

@Service
public class ClassesService {
    @Autowired
    private ClassesDao classesDao;

    public Classes getClasses(long id) {
        Classes classes = classesDao.getClasses(id);
        if (classes == null) {
            throw new NotFoundException("id: " + id + " in classes table not found");
        }
        return classesDao.getClasses(id);
    }

    public List<Classes> getClassesPagination(int limit,Integer offset) {
        return this.classesDao.getClassesPagination(limit, offset);
    }

    public Classes inserClasses(
           Integer name,
           Integer managerId,
           Integer gradeId) {
        Classes classes = new Classes();
        classes.setName(name);
        classes.setManagerId(managerId);
        classes.setGradeId(gradeId);
        this.classesDao.insertClasses(classes);
        return classes;
    }

    public Classes inserClasses(Classes classes) {
        if (classes.getName() == 0) {

        }
        this.classesDao.insertClasses(classes);
        return classes;
    }

    public Classes updateClasses(Classes classes) throws NotFoundException {
        this.getClasses(classes.getId());
        this.classesDao.updateClasses(classes);
        return this.getClasses(classes.getId());
    }

    public Classes patchClasses(Classes input) throws NotFoundException {
        Classes classes = this.getClasses(input.getId());
        if (classes != null) {
            if (input.getName()== null) {
                classes.setName(input.getName());
            }
            if (input.getManagerId()== null) {
                classes.setManagerId(input.getManagerId());
            }
            if (input.getGradeId()== null) {
                classes.setGradeId(input.getGradeId());
            }
            return this.updateClasses(classes);
        }
        return null;
    }

    public boolean deleteClasses(long id) throws NotFoundException {
        this.getClasses(id);
        this.classesDao.deleteClasses(id);
        try {
            Classes classes = this.getClasses(id);
            return classes == null;
        } catch (NotFoundException e) {
            return true;
        }
    }
}
