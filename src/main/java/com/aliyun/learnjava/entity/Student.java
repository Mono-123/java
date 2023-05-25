package com.aliyun.learnjava.entity;

public class Student {
    private long id;
    private String name;
    private int gender;
    private int grade;
    private int score;

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getGender() {
        return gender;
    }

    public int getGrade() {
        return grade;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Student: ");
        sb.append(this.id);
        sb.append(", name: ");
        sb.append(name);
        sb.append(", grade: ");
        sb.append(this.grade);
        sb.append(", gender: ");
        sb.append(this.gender);
        sb.append(", score: ");
        sb.append(this.score);
        return sb.toString();
    }
}
