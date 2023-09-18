package model.entity;

import model.util.EmployeeRole;

import java.util.Date;
import java.util.Optional;

public class Employee extends NaturalEntity{
    protected EmployeeRole role;

    public Employee(int id, Date birthDate, int phoneNumber, String emailAddress){
        super(id, birthDate, phoneNumber, emailAddress);
    }
    public Employee(int id, Date birthDate, String emailAddress){
        this(id, birthDate, -1, emailAddress);
    }
    public Employee(){
        this(-1, null, "");
    }

    public <P extends Person> Optional<P> setBasicData(int id, Date birthDate, String emailAddress){
        return Optional.of((P) new Employee(id, birthDate, emailAddress));
    }


}
