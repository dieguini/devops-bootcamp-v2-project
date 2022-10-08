package services;

public class ServiceFacade {
    ReadDataService readDataService;
    WriteDataService writeDataService;

    ServiceFacade(){
        this.readDataService = new ReadDataService();
        //this.writeDataService = new Wri
    }
}
