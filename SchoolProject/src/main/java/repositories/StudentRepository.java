package repositories;

import models.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    private List<Student> students;

    public StudentRepository() {
        this.students = new ArrayList<>();
    }

    public List<Student> getAllStudents() {
        return this.students;
    }

    public Student getStudentByCode(String code) {
        return students.stream().filter(student -> student.getCode().equals(code)).findAny().orElse(null);
    }

    public void addStudent(Student s) {
        this.students.add(s);
    }
}
