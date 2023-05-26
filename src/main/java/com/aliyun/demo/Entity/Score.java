package com.aliyun.demo.Entity;

public class Score {
    private long id;
    private long studentId;
    private int chinese;
    private int math;
    private int english;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return this.id;
    }

    public void setstudentId(long studentId) {
        this.studentId = studentId;
    }

    public long getstudentId() {
        return this.studentId;
    }

    public void setchinese(int chinese) {
        this.chinese = chinese;
    }

    public int getchinese() {
        return this.chinese;
    }

    public void setMath(int grade) {
        this.math = grade;
    }

    public int getMath() {
        return this.math;
    }

    public void setenglish(int english) {
        this.english = english;
    }

    public int getenglish() {
        return this.english;
    }

    public Score() {}

    public Score(long studentId, int chinese, int grade , int english) {
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

    public int get_Score() {
        return 0;
    }
}
