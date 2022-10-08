import models.School;
import models.Student;
import models.Teacher;
import repositories.StudentRepository;
import repositories.interfaces.IStudentRepository;
import services.AccessValidator;
import services.ReadDataService;
import services.WriteDataService;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        StudentRepository studentRepository = new StudentRepository();

        ReadDataService readDataService = new ReadDataService();
        List<Student> students = readDataService.readStudentsDataFromJson();

        for(Student student : students){
            System.out.println(student);
        }

        WriteDataService writeDataService = new WriteDataService(studentRepository);
        writeDataService.writeStudentsDataToRepository(students);

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

        while (!access) {
            System.out.println("Please enter your code");
            AccessValidator accessValidator = new AccessValidator(studentRepository);

            String code = scanner.nextLine();

            switch (option) {
                case "1":
                    Teacher teacher = accessValidator.verifyTeacherAccess(code);
                    if (teacher != null) {
                        access = true;
                        break;
                    }
                case "2":
                    Student student = accessValidator.verifyStudentAccess(code);
                    if (student != null) {
                        access = true;
                        break;
                    }
            }
        }
    }
}
