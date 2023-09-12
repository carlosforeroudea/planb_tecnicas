package model.account.entity;

import java.util.Date;

abstract public class LegalEntity implements Person{
    private final int ID;
    private final Date foundationDate;

    private String name;

    LegalEntity(int id){
        this.ID = id;
        this.foundationDate = null;

        this.name = "";
    }

    @Override
    public int getIdentificationNumber() {
        return this.ID;
    }

    @Override
    public Date getBirthDate() {
        return this.foundationDate;
    }
}
