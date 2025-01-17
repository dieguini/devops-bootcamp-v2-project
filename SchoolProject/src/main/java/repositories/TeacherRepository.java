package repositories;

import models.Teacher;
import repositories.interfaces.ITeacherRepository;

import java.util.ArrayList;
import java.util.List;

public class TeacherRepository implements ITeacherRepository {
    private List<Teacher> teachers;

    public TeacherRepository() {
        this.teachers = new ArrayList<>();
    }

    @Override
    public List<Teacher> getAll() {
        return this.teachers;
    }

    @Override
    public Teacher getByCode(String code) {
        return getAll().stream().filter(
            teacher -> teacher.getCode().equals(code)
        ).findFirst()
        .orElse(null);
    }

    @Override
    public <S extends Teacher> S add(S s) {
        this.teachers.add(s);
        return s;
    }

    /* @Override
    public List<Teacher> getAllTeachers() {
        return this.teachers;
    }

    @Override
    public Teacher getTeacherByCode(String code) {
        return teachers.stream().filter(
            teacher -> teacher.getCode().equals(code)
        ).findAny().orElse(null);
    }

    @Override
    public void addTeacher(Teacher t) {
        this.teachers.add(t);
    } */

    /* public List<Teacher> getAllTeachers() {
        return this.teachers;
    }

    public Teacher getTeacherByCode(String code) {
        return teachers.stream().filter(teacher -> teacher.getCode().equals(code)).findAny().orElse(null);
    }

    public void addTeacher(Teacher t) {
        this.teachers.add(t);
    } */
}
