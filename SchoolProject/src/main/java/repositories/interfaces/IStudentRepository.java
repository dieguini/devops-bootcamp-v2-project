package repositories.interfaces;

import java.util.List;

import helpers.Grade;
import models.Student;

public interface IStudentRepository extends IRepository<Student, String> {
    
    List<Student> getStudentsByGrade(Grade grade);
}
