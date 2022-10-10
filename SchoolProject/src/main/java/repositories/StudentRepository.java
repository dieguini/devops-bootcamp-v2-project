package repositories;

import models.Student;
import repositories.interfaces.IStudentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.security.auth.Subject;

import helpers.Grade;

public class StudentRepository implements IStudentRepository {
    private List<Student> students;

    public StudentRepository() {
        this.students = new ArrayList<>();
    }

    //implements from IRepository
    @Override
    public List<Student> getAll() {
        return this.students;
    }

    @Override
    public Student getByCode(String code) {
        return students.stream().filter(
            student -> student.getCode().equals(code)
            ).findAny().orElse(null);
    }

    @Override
    public <S extends Student> S add(S s) {
        this.students.add(s);
        return s;
    }

    //implements from IStudentRepository
    @Override
    public List<Student> getStudentsByGrade(Grade grade) {
        return students.stream().filter(
            student -> student.getGrade().equals(grade)
        ).collect(Collectors.toList());
    }
}
