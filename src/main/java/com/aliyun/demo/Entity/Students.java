package com.aliyun.demo.Entity;

public class Students {
    private long id;
    private String name;
    private int managerId;
    private int gradeId;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
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


    public Students() {}

    public Students(String name, int managerId, int gradeId , int score) {
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
