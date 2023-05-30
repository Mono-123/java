package com.aliyun.learnjava.entity;

public class Classes {
    private long id;
    private Integer name;
    private Integer managerId;
    private Integer gradeId;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return this.id;
    }

    public void setName(Integer name) {
        this.name = name;
    }

    public Integer getName() {
        return this.name;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public Integer getManagerId() {
        return this.managerId;
    }

    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }

    public Integer getGradeId() {
        return this.gradeId;
    }

    public Classes() {}

    public Classes(Integer name, Integer managerId, Integer gradeId , Integer score) {
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
