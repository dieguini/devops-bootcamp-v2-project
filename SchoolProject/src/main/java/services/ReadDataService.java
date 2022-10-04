package services;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import models.Student;

import java.io.File;
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
}
