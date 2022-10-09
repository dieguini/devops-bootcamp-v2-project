package commands.menuTeacher;

import commands.ITeacherOperations;
import models.Teacher;

public class MenuTeacherOptions {
    private ITeacherOperations lsc;
    private ITeacherOperations lsbgc,
    private ITeacherOperations ssc,
    private ITeacherOperations sgc

    public MenuTeacherOptions(
        Teacher teacher,
        ITeacherOperations lsc,
        ITeacherOperations lsbgc,
        ITeacherOperations ssc,
        ITeacherOperations sgc
        ){
        System.out.println("Welcome Teacher: " + teacher.getName());
        System.out.println("Select your operation: ");
        System.out.println("1. List all students");
        System.out.println("2. List the students of 'ELEMENTARY_SCHOOL' grade");
        System.out.println("3. Enter a grade for a student");
        System.out.println("4. Exit");

        this.lsc = lsc;
        this.lsbgc = lsbgc;
        this.ssc = ssc;
        this.sgc = sgc;
    }

    public void listAllStudents(){
        lsc
    }
}
