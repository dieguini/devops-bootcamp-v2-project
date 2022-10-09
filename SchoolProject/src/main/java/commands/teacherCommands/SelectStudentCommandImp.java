package commands.teacherCommands;

import commands.ITeacherOperations;
import commands.TeacherReciver;
import models.Student;

public class SelectStudentCommandImp implements ITeacherOperations {

    private TeacherReciver teacherReciver;
    private String code;
    private Student student;

    public SelectStudentCommandImp(TeacherReciver teacherReciver, String code){
        this.teacherReciver = teacherReciver;
        this.code = code;
    }

    @Override
    public void execute() {
        this.student = teacherReciver.selectStudent(this.code);
    }

    public Student getStudent(){
        return this.student;
    }
    
}
