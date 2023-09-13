package model.entity;

import org.jetbrains.annotations.NotNull;

import java.util.Date;
import java.util.Objects;

public class LegalEntity implements Person{
    private final int ID;
    private final Date foundationDate;

    private String name;
    private String address;

    LegalEntity(int id){
        this.ID = id;
        this.foundationDate = null;

        this.name = "";
        this.address = "";
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
