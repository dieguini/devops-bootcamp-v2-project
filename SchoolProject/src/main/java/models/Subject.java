package models;

import helpers.Grade;

public class Subject {
    private String code;
    private String name;
    //private Teacher teacher;
    private Grade grade;

    public Subject(String code, String name, Grade grade) {
        this.code = code;
        this.name = name;
        //this.teacher = teacher;
        this.grade = grade;
    }

    /**
     * @return String return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return Grade return the grade
     */
    public Grade getGrade() {
        return grade;
    }

    /**
     * @param grade the grade to set
     */
    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return String.format("Subject: '%1$s' code '%2$s' grade '%3$s'",
            getName(),
            getCode(),
            getGrade()
        );
    }
}
