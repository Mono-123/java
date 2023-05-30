package com.aliyun.learnjava.entity;

public class Teacher {
    
    private long id;
    private String name;
    private Integer gender;

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

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getGender() {
        return this.gender;
    }

    public Teacher() {}

    public Teacher(String name, Integer gender) {
        this.name = name;
        this.gender = gender;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: " + this.id);
        sb.append(", ");
        sb.append("name: " + this.name);
        sb.append(", ");
        sb.append("gender: " + this.gender);
        return sb.toString();
    }
}


