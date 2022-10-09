package commands;

import java.util.ArrayList;
import java.util.List;

public class Invoker {
    private List<ITeacherOperations> iTeacherOperations = new ArrayList<>();

    public void setCommand(ITeacherOperations iTeacherOperations){
        this.iTeacherOperations.add(iTeacherOperations);
    }

    public void executeCommand(){
        this.iTeacherOperations.forEach(x -> x.execute());
        this.iTeacherOperations.clear();
    }
}
