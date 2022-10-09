package menu;

import java.util.Scanner;

import commands.Invoker;
import commands.TeacherReciver;
import commands.teacherCommands.ListStudentsByGradeCommandImp;
import commands.teacherCommands.ListStudentsCommandImp;
import helpers.Grade;
import models.Teacher;
import repositories.StudentRepository;

public class TeacherMenu {
    private Invoker invoker;
    private TeacherReciver teacherReciver;
    private Teacher teacher;

    public TeacherMenu(StudentRepository studentRepository, Teacher teacher){
        invoker = new Invoker();
        teacherReciver = new TeacherReciver(studentRepository);
        this.teacher = teacher;
    }
    
    public void showMenu(){
        System.out.println("\nTeacher: " + this.teacher.getName());
        System.out.println("==================================");
        System.out.println("Select your operation: ");
        System.out.println("1. List all students");
        System.out.println("2. List the students of 'ELEMENTARY_SCHOOL' grade");
        System.out.println("3. Enter a grade for a student");
        System.out.println("4. Exit");
    }

    public void getOption(){
        Scanner scanner = new Scanner(System.in);
        String teacherOption = scanner.nextLine();

        while(teacherOption != "4"){
            switch(teacherOption){
                case "1":
                    ListStudentsCommandImp lsc = new ListStudentsCommandImp(this.teacherReciver);
                    invoker.setCommand(lsc);
                    invoker.executeCommand();
                break;
                case "2":
                    ListStudentsByGradeCommandImp lsbgc = new ListStudentsByGradeCommandImp(
                        this.teacherReciver,
                        Grade.ELEMENTARY_SCHOOL
                        );
                    invoker.setCommand(lsbgc);
                    invoker.executeCommand();
                break;
                case "3":
                    TeacherSubMenu teacherSubMenu = new TeacherSubMenu(this.teacherReciver, this.invoker);
                    teacherSubMenu.showStudentsCode();
                    teacherSubMenu.enterCode();
                    teacherSubMenu.showGrades();
                    String code = teacherSubMenu.showGrades();
                    teacherSubMenu.enterGrade(code);
                break;
                default:
                    System.out.println("Incorrect option");
                break;
            }

            showMenu();
            teacherOption = scanner.nextLine();
        }
        System.out.println("Bye!");
    }
}
