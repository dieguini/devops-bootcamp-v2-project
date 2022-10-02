package services;

import models.Student;
import repositories.StudentRepository;

import java.util.List;

public class WriteDataService {
    private StudentRepository studentRepository;

    public WriteDataService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void writeStudentsDataToRepository(List<Student> students) {
        students.forEach(student -> this.studentRepository.addStudent(student));
    }
}
