package commands.teacherCommands;

import commands.ITeacherOperations;
import commands.TeacherReciver;
import helpers.Grade;

public class ListStudentsByGradeCommandImp implements ITeacherOperations {

    private TeacherReciver teacherReciver;
    private Grade grade;

    public ListStudentsByGradeCommandImp(TeacherReciver teacherReciver, Grade grade){
        this.teacherReciver = teacherReciver;
        this.grade = grade;
    }

    @Override
    public void execute() {
        teacherReciver.listStudentsByGrade(this.grade);
    }
    
}
