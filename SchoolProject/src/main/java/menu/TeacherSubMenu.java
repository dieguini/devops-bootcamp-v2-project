package menu;

import java.util.Scanner;

import commands.Invoker;
import commands.TeacherReciver;
import commands.teacherCommands.ListStudentsCommandImp;
import commands.teacherCommands.SelectStudentCommandImp;
import commands.teacherCommands.SetGradeStudentImp;
import helpers.Grade;

public class TeacherSubMenu {
    private TeacherReciver teacherReciver;
    private Invoker invoker;
    private SelectStudentCommandImp ssc;

    public TeacherSubMenu(TeacherReciver teacherReciver, Invoker invoker){
        this.teacherReciver = teacherReciver;
        this.invoker = invoker;
    }

    public void showStudentsCode(){
        ListStudentsCommandImp lsc = new ListStudentsCommandImp(this.teacherReciver);
        invoker.setCommand(lsc);
        invoker.executeCommand();

        System.out.println("Enter student code: ");
        System.out.println("======================");
    }

    public void enterCode(){
        Scanner scanner = new Scanner(System.in);
        String code = scanner.nextLine();
        
        this.ssc = new SelectStudentCommandImp(this.teacherReciver, code);
        invoker.setCommand(ssc);
        invoker.executeCommand();
    }

    public String showGrades(){
        System.out.println("Grades Available: ");
        for(Grade grade : Grade.values()){
            System.out.println(grade);
        }

        System.out.println("Enter new grade: ");
        Scanner scanner = new Scanner(System.in);
        String code = scanner.nextLine();

        return code;
    }

    public void enterGrade(String studentGrade){
        SetGradeStudentImp sgc = new SetGradeStudentImp(
            teacherReciver, 
            this.ssc.getStudent(), 
            Grade.valueOf(studentGrade)
        );
        invoker.setCommand(sgc);
        invoker.executeCommand();

        System.out.println(sgc.getStudent());
    }
}
