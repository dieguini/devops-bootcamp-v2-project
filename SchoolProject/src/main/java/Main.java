import models.School;
import models.Student;
import models.Subject;
import models.Teacher;
import repositories.StudentRepository;
import repositories.SubjectRepository;
import repositories.TeacherRepository;
import services.AccessValidator;
import services.ReadDataService;
import services.ServiceFacade;
import services.WriteDataService;

import java.util.List;
import java.util.Scanner;

import menu.TeacherMenu;

public class Main {
    public static void main(String args[]) {
        ServiceFacade serviceFacade = new ServiceFacade();

        StudentRepository studentRepository = new StudentRepository();
        TeacherRepository teacherRepository = new TeacherRepository();
        SubjectRepository subjectRepository = new SubjectRepository();

        List<Student> students = serviceFacade.readStudentsDataFromJson();
        List<Teacher> teachers = serviceFacade.readTeachersDataFromJson();
        List<Subject> subjects = serviceFacade.readSubjectsDataFromJson();

        serviceFacade.readAndWriteRepoService(studentRepository, students);
        serviceFacade.readAndWriteRepoService(teacherRepository, teachers);
        serviceFacade.readAndWriteRepoService(subjectRepository, subjects);

        Scanner scanner = new Scanner(System.in);
        School school = new School("American School");

        System.out.println("=============================");
        System.out.println("Welcome to " + school.getName());
        System.out.println("=============================");

        System.out.println("Select your role please: ");
        System.out.println("1. Teacher");
        System.out.println("2. Student");

        String option = scanner.nextLine();
        boolean access = false;

        //TODO strategy pattern for options could work better
        //Strategy for teachers
        //Strategy for students

        while (!access) {
            System.out.println("Please enter your code");
            String code = scanner.nextLine();

            switch (option) {
                case "1":
                    
                    Teacher teacher = (Teacher) serviceFacade.validateAccess(teacherRepository, code);
                    //System.out.println("Welcome Teacher: " + teacher.getName());
                    if (teacher != null) {
                        TeacherMenu teacherMenu = new TeacherMenu(studentRepository, teacher);
                        teacherMenu.showMenu();
                        teacherMenu.getOption();

                        access = true;
                        /* TeacherReciver teacherReciver = new TeacherReciver(studentRepository);
                        System.out.println("Select your operation: ");
                        System.out.println("1. List all students");
                        System.out.println("2. List the students of 'ELEMENTARY_SCHOOL' grade");
                        System.out.println("3. Enter a grade for a student");
                        System.out.println("4. Exit");
                        String teacherOption = scanner.nextLine();
                        Invoker invoker = new Invoker(); */
                        /* switch(teacherOption){
                            case "1":
                                ListStudentsCommandImp lsc = new ListStudentsCommandImp(teacherReciver);
                                invoker.setCommand(lsc);
                                invoker.executeCommand();
                            break;
                            case "2":
                                ListStudentsByGradeCommandImp lsbgc = new ListStudentsByGradeCommandImp(
                                    teacherReciver,
                                    Grade.ELEMENTARY_SCHOOL
                                    );
                                invoker.setCommand(lsbgc);
                                invoker.executeCommand();
                            break;
                            case "3":
                                ListStudentsCommandImp lsc2 = new ListStudentsCommandImp(teacherReciver);
                                invoker.setCommand(lsc2);
                                invoker.executeCommand();

                                System.out.println("Enter student code: ");
                                System.out.println("======================");
                                String studentCode = scanner.nextLine();

                                SelectStudentCommandImp ssc = new SelectStudentCommandImp(teacherReciver, studentCode);
                                invoker.setCommand(ssc);
                                invoker.executeCommand();

                                System.out.println("Enter new grade: ");

                                for(Grade grade : Grade.values()){
                                    System.out.println(grade);
                                }
                                String studentGrade = scanner.nextLine();
                                System.out.println("=================");

                                SetGradeStudentImp sgc = new SetGradeStudentImp(teacherReciver, ssc.getStudent()
                                    , Grade.valueOf(studentGrade)
                                );
                                invoker.setCommand(sgc);
                                invoker.executeCommand();

                                System.out.println(sgc.getStudent());

                            break;
                        } */
                        break;
                    }

                case "2":
                    Student student = (Student) serviceFacade.validateAccess(studentRepository, code);
                    if (student != null) {
                        System.out.println("Welcome Student: " + student.getName()+ " grade: " + student.getGrade());
                        System.out.println("Subject list: ");
                        List<Subject> mySubjects = subjectRepository.getSubjectsByStudent(student);
                        for(Subject sub : mySubjects){
                            System.out.println(sub);
                        }
                        access = true;
                        break;
                    }
            }
        }
    }
}
