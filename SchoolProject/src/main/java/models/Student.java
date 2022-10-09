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
        this.code = "ST-" + (int)(Math.random() * 100 + 1)+ "-" + name;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    /**
     * @return String return the name
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
     * @return int return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
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

    /**
     * @return Score return the score
     */
    public Score getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(Score score) {
        this.score = score;
    }

    /* public String getCode() {
        return code;
    }

    public String getScore() {
        return getScore();
    } */

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        //return super.toString();
        return String.format("Student: '%1$s' code '%2$s' age '%3$s' grade '%4$s' score '%5$s'", 
            getName(),
            getCode(),
            getAge(),
            getGrade(),
            getScore()
        );
        //return "Student {1} score {2}";
    }

}
