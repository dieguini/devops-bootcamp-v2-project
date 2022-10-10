package repositories.interfaces;

import java.util.List;

import models.Student;
import models.Subject;

public interface ISubjectRepository extends IRepository<Subject, String> {
    List<Subject> getSubjectsByStudent(Student student);
}
