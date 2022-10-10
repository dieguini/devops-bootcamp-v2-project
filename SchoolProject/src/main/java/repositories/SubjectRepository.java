package repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import models.Student;
import models.Subject;
import repositories.interfaces.ISubjectRepository;

public class SubjectRepository implements ISubjectRepository {
    private List<Subject> subjects;

    public SubjectRepository(){
        this.subjects = new ArrayList<>();
    }

    @Override
    public List<Subject> getAll() {
        return this.subjects;
    }

    @Override
    public List<Subject> getSubjectsByStudent(Student student) {
        return subjects.stream().filter(
            subject -> subject.getGrade().equals(student.getGrade())
        ).collect(Collectors.toList());
    }

    @Override
    public Subject getByCode(String code) {
        return getAll().stream().filter(
            subject -> subject.getCode().equals(code)
        ).findFirst()
        .orElse(null);
    }

    @Override
    public <S extends Subject> S add(S s) {
        subjects.add(s);
        return s;
    }
}
