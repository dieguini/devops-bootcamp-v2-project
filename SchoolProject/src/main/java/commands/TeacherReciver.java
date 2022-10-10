package commands;

import helpers.Grade;
import models.Student;
import repositories.StudentRepository;

public class TeacherReciver {
    
    private StudentRepository studentRepository;

    public TeacherReciver(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public void listStudents(){
        for(Student student : this.studentRepository.getAll()){
            System.out.println(student);
        }
    }

    public void listStudentsByGrade(Grade grade){
        System.out.println("####################################");
        System.out.println("List students of grade: "+ grade);
        for(Student student : this.studentRepository.getStudentsByGrade(grade)){
            System.out.println(student);
        }
    }

    public Student selectStudent(String code){
        System.out.println("####################################");
        System.out.println("Selecting student with code: "+code);
        return this.studentRepository.getByCode(code);
    }

    public Student setGradeStudent(Student student, Grade grade){
        System.out.println("####################################");
        System.out.println("Setting grade for student '"+ student.getName() +"': "+grade);
        student.setGrade(grade);
        return student;
    }
}
