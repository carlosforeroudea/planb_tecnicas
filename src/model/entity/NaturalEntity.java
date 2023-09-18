package model.entity;

import org.jetbrains.annotations.NotNull;

import java.util.Date;
import java.util.Objects;
import java.util.Optional;

public class NaturalEntity implements Person {
    protected final int identification;
    protected final Date birthDate;

    protected String firstName;
    protected String secondName;
    protected String firstSurname;
    protected String secondSurname;

    protected int phoneNumber;
    protected String email;

    protected String address;

    public NaturalEntity(int id, Date birthDate, int phoneNumber, String emailAddress){
        this.identification = id;
        this.birthDate = birthDate;

        this.firstName = "";
        this.secondName = "";
        this.firstSurname = "";
        this.secondSurname = "";

        this.phoneNumber = phoneNumber;
        this.email = emailAddress;

        this.address = "";
    }
    public NaturalEntity(int id, Date birthDate, String emailAddress){
        this(id, birthDate, -1, emailAddress);
    }
    public NaturalEntity(){
        this(-1, null, "");
    }

    public <P extends Person> Optional<P> setBasicData(int id, Date birthDate, String emailAddress){
        return Optional.of((P) new NaturalEntity(id, birthDate, emailAddress));
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
