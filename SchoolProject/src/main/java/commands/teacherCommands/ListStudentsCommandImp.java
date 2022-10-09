package commands.teacherCommands;

import commands.ITeacherOperations;
import commands.TeacherReciver;
import helpers.Grade;

public class ListStudentsCommandImp implements ITeacherOperations {

    private TeacherReciver teacherReciver;

    public ListStudentsCommandImp(TeacherReciver teacherReciver){
        this.teacherReciver = teacherReciver;
    }

    @Override
    public void execute() {
        teacherReciver.listStudents();
    }
    
}
