package services;

import java.util.List;

import models.Student;
import models.Subject;
import models.Teacher;
import repositories.interfaces.IRepository;

public class ServiceFacade {
    
    WriteDataService writeDataService;
    private AccessValidator accessValidator;
    private ReadDataService readDataService;

    public ServiceFacade(){
        this.readDataService = new ReadDataService();
    }

    /**
     * Method that accepts any reposytory for access control code
     * 
     * @param iRepository
     * @param code
     * @return Any kind of object (Teacher or Student) depending on repository
     */
    public Object validateAccess(IRepository iRepository, String code){
        accessValidator = new AccessValidator(iRepository);
        return accessValidator.verifyAccess(code);
    }

    /**
     * Method that reads and writes any type of repository
     * Using de services such as:
     *  - ReadDataService
     *  - WriteDataService
     * 
     * @param <T>
     * @param iRepository
     * @param objectList
     */
    public <T> void readAndWriteRepoService(
            IRepository iRepository,
            List<T> objList
        ){

        writeDataService = new WriteDataService(iRepository);
        writeDataService.writeDataToRepository(objList);
    }

    public List<Student> readStudentsDataFromJson(){
        return readDataService.readStudentsDataFromJson();
    }

    public List<Teacher> readTeachersDataFromJson(){
        return readDataService.readTeachersDataFromJson();
    }

    public List<Subject> readSubjectsDataFromJson(){
        return readDataService.readSubjectsDataFromJson();
    }
}
