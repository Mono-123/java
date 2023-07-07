package com.aliyun.learnjava.entity;

public class Student {
    private long id;
    private String name;
    private Integer gender;
    private Integer grade;
    private Integer score;
    private String img;

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public long getId() {
        return id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public Integer getGender() {
        return gender;
    }

    public Integer getGrade() {
        return grade;
    }

    public Integer getScore() {
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
        sb.append(", img: ");
        sb.append(this.img);
        return sb.toString();
    }

}
