package com.aliyun.demo.Entity;

public class Grade {
    private long id;
    private int grade;
    private int managerId;
    private int isGraduated;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return this.id;
    }

    public void setName(int grade) {
        this.grade = grade;
    }

    public int getName() {
        return this.grade;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public int getManagerId() {
        return this.managerId;
    }

    public void setisGraduated(int isGraduated) {
        this.isGraduated = isGraduated;
    }

    public int getisGraduated() {
        return this.isGraduated;
    }

    public Grade() {}

    public Grade(int grade, int managerId, int isGraduated) {
        this.grade = grade;
        this.managerId = managerId;
        this.isGraduated = isGraduated;
    
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: " + this.id);
        sb.append(", ");
        sb.append("grade: " + this.grade);
        sb.append(", ");
        sb.append("managerId: " + this.managerId);
        sb.append(", ");
        sb.append("isGraduated: " + this.isGraduated);
        return sb.toString();
    }

}
