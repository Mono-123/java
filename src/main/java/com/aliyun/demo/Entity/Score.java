package com.aliyun.demo.Entity;

public class Score {
    private long id;
    private long student_id;
    private int chinese;
    private int math;
    private int english;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return this.id;
    }

    public void setstudent_id(long student_id) {
        this.student_id = student_id;
    }

    public long getstudent_id() {
        return this.student_id;
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

    public Score(long student_id, int chinese, int grade , int english) {
        this.student_id = student_id;
        this.chinese = chinese;
        this.math = grade;
        this.english = english;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: " + this.id);
        sb.append(", ");
        sb.append("student_id: " + this.student_id);
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
