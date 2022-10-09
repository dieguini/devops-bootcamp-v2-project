package models;

import helpers.Grade;

import java.util.ArrayList;
import java.util.List;

public class Teacher {
    private String code;
    private String name;
    private List<Subject> subjectList;

    public Teacher(String name) {
        this.code = "TE-" + (int)(Math.random() * 100 + 1) + "-" + name;
        this.name = name;
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

    public void addSubject(Subject sub) {
        if (this.subjectList == null) {
            this.subjectList = new ArrayList<>();
        }

        this.subjectList.add(sub);
    }

    @Override
    public String toString() {
        return String.format("Teacher: '%1$s' code '%2$s'", 
            getName(),
            getCode()
        );
    }
}
