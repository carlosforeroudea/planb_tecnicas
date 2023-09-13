package model.entity;

import model.util.EmployeeRole;

import java.util.Date;

public class Employee implements Person{
    protected EmployeeRole role;

    public Employee(){

    }

    @Override
    public int getIdentificationNumber() {
        return 0;
    }

    @Override
    public Date getBirthDate() {
        return null;
    }

    @Override
    public String getAddress() {
        return null;
    }

    @Override
    public String getLegalAddress() {
        return null;
    }

    @Override
    public String getSocialAddress() {
        return null;
    }

    @Override
    public String getFullName() {
        return null;
    }
}
