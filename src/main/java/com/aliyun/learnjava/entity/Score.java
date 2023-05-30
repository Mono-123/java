package com.aliyun.learnjava.entity;

public class Score {
    private long id;
    private int studentId;
    private int chinese;
    private int math;
    private int english;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return this.id;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getStudentId() {
        return this.studentId;
    }

    public void setChinese(int chinese) {
        this.chinese = chinese;
    }

    public int getChinese() {
        return this.chinese;
    }

    public void setMath(int grade) {
        this.math = grade;
    }

    public int getMath() {
        return this.math;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public int getEnglish() {
        return this.english;
    }

    public Score() {}

    public Score(int studentId, int chinese, int grade , int english) {
        this.studentId = studentId;
        this.chinese = chinese;
        this.math = grade;
        this.english = english;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: " + this.id);
        sb.append(", ");
        sb.append("studentId: " + this.studentId);
        sb.append(", ");
        sb.append("chinese: " + this.chinese);
        sb.append(", ");
        sb.append("grade: " + this.math);
        sb.append(", ");
        sb.append("english: " + this.english);
        return sb.toString();
    }
}
