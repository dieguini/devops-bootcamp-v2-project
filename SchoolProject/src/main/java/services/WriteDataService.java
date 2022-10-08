package services;

import models.Student;
import models.Teacher;
import repositories.StudentRepository;
import repositories.TeacherRepository;
import repositories.interfaces.IPersonRepository;
import repositories.interfaces.IStudentRepository;

import java.util.List;

public class WriteDataService {
    private StudentRepository studentRepository;
    private TeacherRepository teacherRepository;

    public WriteDataService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public WriteDataService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public void writeStudentsDataToRepository(List<Student> students) {
        students.forEach(student -> this.studentRepository.addPerson(student));
    }

    public void writeTeachersDataToRepository(List<Teacher> teachers) {
        teachers.forEach(teacher -> this.teacherRepository.addPerson(teacher));
    }
}
