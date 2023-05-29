package com.aliyun.learnjava.entity;

public class Classes {
    private long id;
    private int name;
    private int managerId;
    private int gradeId;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return this.id;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getName() {
        return this.name;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public int getManagerId() {
        return this.managerId;
    }

    public void setGradeId(int gradeId) {
        this.gradeId = gradeId;
    }

    public int getGradeId() {
        return this.gradeId;
    }

    public Classes() {}

    public Classes(int name, int managerId, int gradeId , int score) {
        this.name = name;
        this.managerId = managerId;
        this.gradeId = gradeId;
    
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: " + this.id);
        sb.append(", ");
        sb.append("name: " + this.name);
        sb.append(", ");
        sb.append("managerId: " + this.managerId);
        sb.append(", ");
        sb.append("gradeId: " + this.gradeId);
        return sb.toString();
    }
}
