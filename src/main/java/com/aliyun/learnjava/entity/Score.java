package com.aliyun.learnjava.entity;

public class Score {
    private long id;
    private Integer studentId;
    private Integer chinese;
    private Integer math;
    private Integer english;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return this.id;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getStudentId() {
        return this.studentId;
    }

    public void setChinese(Integer chinese) {
        this.chinese = chinese;
    }

    public Integer getChinese() {
        return this.chinese;
    }

    public void setMath(Integer grade) {
        this.math = grade;
    }

    public Integer getMath() {
        return this.math;
    }

    public void setEnglish(Integer english) {
        this.english = english;
    }

    public Integer getEnglish() {
        return this.english;
    }

    public Score() {}

    public Score(Integer studentId, Integer chinese, Integer grade , Integer english) {
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
