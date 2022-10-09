package commands.teacherCommands;

import commands.ITeacherOperations;
import commands.TeacherReciver;
import helpers.Grade;
import models.Student;

public class SetGradeStudentImp implements ITeacherOperations {

    private TeacherReciver teacherReciver;
    private Student student;
    private Grade grade;

    public SetGradeStudentImp(TeacherReciver teacherReciver, Student student, Grade grade){
        this.teacherReciver = teacherReciver;
        this.student = student;
        this.grade = grade;
    }

    @Override
    public void execute() {
        this.student = this.teacherReciver.setGradeStudent(this.student, this.grade);
    }
    
    public Student getStudent(){
        return this.student;
    }
}
