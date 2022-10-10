package services;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import models.Student;
import models.Subject;
import models.Teacher;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ReadDataService {
    public ReadDataService() {}

    public List<Student> readStudentsDataFromJson() {
        List<Student> students = null;
            
        try {
            Gson gson = new Gson();
            String filename="SchoolProject/src/main/resources/students.json";
            Path pathToFile = Paths.get(filename);
            
            Reader reader = Files.newBufferedReader(pathToFile);

            students = gson.fromJson(reader, new TypeToken<List<Student>>() {}.getType());
            reader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return students;
    }

    public List<Teacher> readTeachersDataFromJson(){
        List<Teacher> teachers = null;
            
        try {
            Gson gson = new Gson();
            String filename="SchoolProject/src/main/resources/teachers.json";
            Path pathToFile = Paths.get(filename);
            
            Reader reader = Files.newBufferedReader(pathToFile);

            teachers = gson.fromJson(reader, new TypeToken<List<Teacher>>() {}.getType());
            reader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return teachers;
    }

    public List<Subject> readSubjectsDataFromJson(){
        List<Subject> subjects = null;
            
        try {
            Gson gson = new Gson();
            String filename="SchoolProject/src/main/resources/subjects.json";
            Path pathToFile = Paths.get(filename);
            
            Reader reader = Files.newBufferedReader(pathToFile);

            subjects = gson.fromJson(reader, new TypeToken<List<Subject>>() {}.getType());
            reader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return subjects;
    }

    // TODO make it work with multiple objects
    /* public <T> List<T> readDataFromJson(String filename) {
        List<T> list = null;
            
        try {
            Gson gson = new Gson();
            //String filename="SchoolProject/src/main/resources/students.json";
            Path pathToFile = Paths.get(filename);
            
            Reader reader = Files.newBufferedReader(pathToFile);

            list = gson.fromJson(reader, new TypeToken<List<T>>() {}.getType());
            reader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    } */
}
