package model.entity;

import org.jetbrains.annotations.NotNull;

import java.util.Date;
import java.util.Objects;

public class NaturalEntity implements Person {
    private final int identification;
    private final Date birthDate;

    private String firstName;
    private String secondName;
    private String firstSurname;
    private String secondSurname;

    private String address;

    NaturalEntity(int id){
        this.identification = id;
        this.birthDate = null;

        this.firstName = "";
        this.secondName = "";
        this.firstSurname = "";
        this.secondSurname = "";

        this.address = "";
    }

    @Override
    public int getIdentificationNumber() {
        return this.identification;
    }

    @Override
    public Date getBirthDate() {
        return this.birthDate;
    }

    @Override
    public String getFullName() {
        String fullName = this.firstName;

        if(!Objects.equals(this.secondName, ""))
            fullName += " " + this.secondName;
        if(!Objects.equals(this.firstSurname, ""))
            fullName += " " + this.firstSurname;
        if(!Objects.equals(this.secondSurname, ""))
            fullName += " " + this.secondSurname;

        return fullName;
    }

    public boolean changeFirstName(@NotNull String newName){
        if(Objects.equals(newName, ""))
            return false;

        this.firstName = newName;
        return true;
    }
    public boolean changeSecondName(@NotNull String newName){
        this.secondName = newName;
        return true;
    }
    public boolean changeFirstSurname(@NotNull String newSurname){
        if(Objects.equals(newSurname, ""))
            return false;

        this.firstName = newSurname;
        return true;
    }
    public boolean changeSecondSurname(@NotNull String newSurname){
        this.firstName = newSurname;
        return true;
    }

    int changeNames(@NotNull String newFirstName, @NotNull String newSecondName){
        int result = 0b00;
        result |= this.changeFirstName(newFirstName) ? 0b01 : 0b00;
        result |= this.changeSecondName(newSecondName) ? 0b10 : 0b00;

        return result;
    }

    @Override
    public String getAddress() {
        return this.address;
    }

    @Override
    public String getLegalAddress() {
        return "";
    }
    @Override
    public String getSocialAddress() {
        return "";
    }
}
