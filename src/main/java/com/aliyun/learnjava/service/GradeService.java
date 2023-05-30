package com.aliyun.learnjava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aliyun.exception.NotFoundException;
import com.aliyun.learnjava.dao.GradeDao;
import com.aliyun.learnjava.entity.Grade;

@Service
public class GradeService {
    @Autowired
    private GradeDao gradeDao;

    public Grade getGrade(long id) {
         Grade grade = gradeDao.getGrade(id);
        if (grade == null) {
            throw new NotFoundException("id: " + id + " in grade table not found");
        }
        return gradeDao.getGrade(id);
    }

    public List<Grade> getGradePagination(int limit, int offset) {
        return this.gradeDao.getGradePagination(limit, offset);
    }
    public Grade inserGrade(
            int name,
            int managerId,
            int gradeId) {
        Grade grade = new Grade();
        grade.setGrade(name);
        grade.setManagerId(managerId);
        grade.setIsGraduated(gradeId);
        this.gradeDao.insertGrade(grade);
        return grade;
    }

    public Grade inserGrade(Grade grade) {
        if (grade.getGrade() == 0) {

        }
        this.gradeDao.insertGrade(grade);
        return grade;
    }

    public Grade updateGrade(Grade grade) throws NotFoundException {
        this.getGrade(grade.getId());
        this.gradeDao.updateGrade(grade);
        return this.getGrade(grade.getId());
    }

    public List<Grade> updateGraduate(){
        this.gradeDao.updateGraduate();
        return this.gradeDao.getGraduate(); 
    }

    public Grade patchGrade(Grade input) throws NotFoundException {
        Grade grade = this.getGrade(input.getId());
        if (grade != null) {
            if (input.getGrade() != 0) {
                grade.setGrade(input.getGrade());
            }
            if (input.getManagerId() != 0) {
                grade.setManagerId(input.getManagerId());
            }
            if (input.getIsGraduated() != 0) {
                grade.setIsGraduated(input.getIsGraduated());
            }
            return this.updateGrade(grade);
        }
        return null;
    }


    public boolean deleteGrade(long id) throws NotFoundException {
        this.getGrade(id);
        this.gradeDao.deleteGrade(id);
        try {
            Grade grade = this.getGrade(id);
            return grade == null;
        } catch (NotFoundException e) {
            return true;
        }
    }
}
