package com.aliyun.learnjava.entity;

public class Students {
    private long id;
    private String name;
    private int gender;
    private int classId;

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

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getGender() {
        return this.gender;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getClassId() {
        return this.classId;
    }


    public Students() {}

    public Students(String name, int gender, int classId , int score) {
        this.name = name;
        this.gender = gender;
        this.classId = classId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: " + this.id);
        sb.append(", ");
        sb.append("name: " + this.name);
        sb.append(", ");
        sb.append("gender: " + this.gender);
        sb.append(", ");
        sb.append("classId: " + this.classId);
        return sb.toString();
    }
}
