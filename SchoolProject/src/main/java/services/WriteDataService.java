package services;

import repositories.interfaces.IPersonRepository;

import java.util.List;

public class WriteDataService {
    private IPersonRepository iPersonRepository;

    public WriteDataService(IPersonRepository iPersonRepository){
        this.iPersonRepository = iPersonRepository;
    }

    public <T> void writeDataToRepository(List<T> persons){
        persons.forEach(person -> this.iPersonRepository.addPerson(person));
    }
}
