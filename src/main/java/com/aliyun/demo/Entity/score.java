package com.aliyun.demo.Entity;

public class score {
    private long id;
    private String name;
    private int grade;
    private int classes;
    private int Chinese;
    private int Math;
    private int English;


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

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getGrade() {
        return this.grade;
    }


    public void setClasses(int classes) {
        this.classes = classes;
    }

    public int getClasses() {
        return this.classes;
    }

    public void setChinese(int Chinese) {
        this.Chinese = Chinese;
    }

    public int getChinese() {
        return this.Chinese;
    }

    public void setMath(int Math) {
        this.Math = Math ;
    }

    public int getMath() {
        return this.Math;
    }

    public void setEnglish(int English) {
        this.English = English;
    }

    public int getEnglish() {
        return this.English;
    }


public  score() {}

public  score(String name, int grade, int classes , int Chinese ,int Math, int English ) {
    this.name = name;
    this.grade = grade;
    this.classes = classes;
    this.Chinese = Chinese;
    this.Math = Math;
    this.English = English;
}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: " + this.id);
        sb.append(", ");
        sb.append("name: " + this.name);
        sb.append(", ");
        sb.append("grade: " + this.grade);
        sb.append(", ");
        sb.append("classes: " + this.classes);
        sb.append(", ");
        sb.append("Chinese: " + this.Chinese);
        sb.append(", ");
        sb.append("Math: " + this.Math);
        sb.append(", ");
        sb.append("English: " + this.English);
        return sb.toString();
    }
}
