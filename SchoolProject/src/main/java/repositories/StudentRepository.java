package repositories;

import models.Student;
import repositories.interfaces.IStudentRepository;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository {
    private List<Student> students;
    //private IStudentRepository repository;

    public StudentRepository() {
        this.students = new ArrayList<>();
    }

    @Override
    public List<Student> getAll() {
        return this.students;
    }

    @Override
    public Student getPersonByCode(String code) {
        return students.stream().filter(
            student -> student.getCode().equals(code)
            ).findAny().orElse(null);
    }

    @Override
    public <S extends Student> S addPerson(S s) {
        this.students.add(s);
        return s;
    }

    /* @Override
    public List<Student> getAllStudents() {
        return this.students;
    }

    @Override
    public Student getStudentByCode(String code) {
        return students.stream().filter(
            student -> student.getCode().equals(code)
            ).findAny().orElse(null);
    }

    @Override
    public void addStudent(Student s) {
        this.students.add(s);
        //this.repository.addStudent(s);
    } */

    /* public List<Student> getAllStudents() {
        return this.students;
    }

    public Student getStudentByCode(String code) {
        return students.stream().filter(student -> student.getCode().equals(code)).findAny().orElse(null);
    }

    public void addStudent(Student s) {
        this.students.add(s);
    } */
}
