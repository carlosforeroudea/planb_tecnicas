package model.account;

import model.account.entity.Person;

import java.util.Date;

public class BankUser extends User {
    public final int personalID;

    public String firstName;
    public String secondName;
    public String firstSurname;
    public String secondSurname;

    BankUser(int bankUserID, int identification){
        super(bankUserID);
        this.personalID = identification;

        this.firstName = "";
        this.secondName = "";
        this.firstSurname = "";
        this.secondSurname = "";
    }

    public int getIdentificationNumber() {
        return this.personalID;
    }

    public Date getBirthDate() {
        return null;
    }

    public String getFullName() {
        return null;
    }

}
