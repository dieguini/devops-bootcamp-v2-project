package commands.teacherCommands;

import commands.ITeacherOperations;
import commands.TeacherReciver;

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
