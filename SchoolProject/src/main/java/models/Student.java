package models;

import helpers.Grade;
import helpers.Score;

public class Student {
    private String code;
    private String name;
    private int age;
    private Grade grade;
    private Score score;

    public Student(String name, int age, Grade grade) {
        this.code = "ST" + (int)(Math.random() * 100 + 1) + name;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public String getCode() {
        return code;
    }

    public String getScore() {
        return getScore();
    }
}
