package services;

import repositories.interfaces.IRepository;

import java.util.List;

public class WriteDataService {
    private IRepository iRepository;

    public WriteDataService(IRepository iRepository){
        this.iRepository = iRepository;
    }

    public <T> void writeDataToRepository(List<T> objects){
        objects.forEach(obj -> this.iRepository.add(obj));
    }
}
