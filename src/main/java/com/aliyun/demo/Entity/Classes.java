package com.aliyun.demo.Entity;

public class Classes {
    private long id;
    private String name;
    private int manager_id;
    private int grade_id;

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

    public void setmanager_id(int manager_id) {
        this.manager_id = manager_id;
    }

    public int getmanager_id() {
        return this.manager_id;
    }

    public void setGrade_id(int grade_id) {
        this.grade_id = grade_id;
    }

    public int getGrade_id() {
        return this.grade_id;
    }

    public Classes() {}

    public Classes(String name, int manager_id, int grade_id , int score) {
        this.name = name;
        this.manager_id = manager_id;
        this.grade_id = grade_id;
    
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: " + this.id);
        sb.append(", ");
        sb.append("name: " + this.name);
        sb.append(", ");
        sb.append("manager_id: " + this.manager_id);
        sb.append(", ");
        sb.append("grade_id: " + this.grade_id);
        return sb.toString();
    }
}
