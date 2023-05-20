package com.aliyun.demo.Entity;

public class Student {
    private long id;
    private String name;
    private int gender;
    private int grade;
    private int score;

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

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getGrade() {
        return this.grade;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return this.score;
    }

    public Student() {}

    public Student(String name, int gender, int grade , int score) {
        this.name = name;
        this.gender = gender;
        this.grade = grade;
        this.score = score;
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
        sb.append("grade: " + this.grade);
        sb.append(", ");
        sb.append("score: " + this.score);
        return sb.toString();
    }
}
