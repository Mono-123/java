package com.aliyun.demo.Entity;

public class Grade {
    private long id;
    private int grade;
    private int manager_id;
    private int is_graduated;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return this.id;
    }

    public void setName(int grade) {
        this.grade = grade;
    }

    public int getName() {
        return this.grade;
    }

    public void setmanager_id(int manager_id) {
        this.manager_id = manager_id;
    }

    public int getmanager_id() {
        return this.manager_id;
    }

    public void setis_graduated(int is_graduated) {
        this.is_graduated = is_graduated;
    }

    public int getis_graduated() {
        return this.is_graduated;
    }

    public Grade() {}

    public Grade(int grade, int manager_id, int is_graduated) {
        this.grade = grade;
        this.manager_id = manager_id;
        this.is_graduated = is_graduated;
    
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: " + this.id);
        sb.append(", ");
        sb.append("grade: " + this.grade);
        sb.append(", ");
        sb.append("manager_id: " + this.manager_id);
        sb.append(", ");
        sb.append("is_graduated: " + this.is_graduated);
        return sb.toString();
    }

}
