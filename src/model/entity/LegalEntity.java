package model.entity;

import org.jetbrains.annotations.NotNull;

import java.util.Date;
import java.util.Objects;
import java.util.Optional;

public class LegalEntity implements Person{
    private final int ID;
    private final Date foundationDate;

    private String name;
    private String email;
    private String address;

    public LegalEntity(int id, String name, Date foundationDate, int contactPhone, String emailAddress, String address){
        this.ID = id;
        this.foundationDate = foundationDate;

        this.name = name;
        this.email = emailAddress;
        this.address = address;
    }
    public LegalEntity(int id, Date foundationDate, String emailAddress){
        this(id, "", foundationDate, -1, emailAddress, "");
    }
    public LegalEntity(){
        this(-1, null, "");
    }

    public <P extends Person> Optional<P> setBasicData(int id, Date birthDate, String emailAddress){
        return Optional.of((P) new LegalEntity(id, birthDate, emailAddress));
    }

    @Override
    public int getIdentificationNumber() {
        return this.ID;
    }

    @Override
    public Date getBirthDate() {
        return this.foundationDate;
    }

    public boolean changeFirstName(@NotNull String newName){
        if(Objects.equals(newName, ""))
            return false;

        this.name = newName;
        return true;
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

    @Override
    public String getFullName() {
        return this.name;
    }
}
