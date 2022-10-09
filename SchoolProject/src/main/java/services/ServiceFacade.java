package services;

import java.util.List;

import repositories.interfaces.IPersonRepository;

public class ServiceFacade {
    
    WriteDataService writeDataService;
    private AccessValidator accessValidator;

    public ServiceFacade(){}

    /**
     * Method that accepts any reposytory for access control code
     * 
     * @param iPersonRepository
     * @param code
     * @return Any kind of object (Teacher or Student) depending on repository
     */
    public Object validateAccess(IPersonRepository iPersonRepository, String code){
        accessValidator = new AccessValidator(iPersonRepository);
        return accessValidator.verifyAccess(code);
    }

    /**
     * Method that reads and writes any type of repository
     * Using de services such as:
     *  - ReadDataService
     *  - WriteDataService
     * 
     * @param <T>
     * @param iPersonRepository
     * @param objectList
     */
    public <T> void readAndWriteRepoService(
            IPersonRepository iPersonRepository,
            List<T> objList
        ){

        writeDataService = new WriteDataService(iPersonRepository);
        writeDataService.writeDataToRepository(objList);
    }
}
