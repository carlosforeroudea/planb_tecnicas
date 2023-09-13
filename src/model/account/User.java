package model.account;

import model.entity.Person;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class User<Entity extends Person> {
    protected final int userID;
    protected final String passHash;
    protected final Entity person;

    public User(int userID, Entity person) {
        this.userID = userID;
        this.passHash = "0"; // Read from file
        this.person = person;
    }

    public int getUserID() {
        return this.userID;
    }
    public Entity getPerson(){
        return this.person;
    }
    public int getPersonID(){
        return this.person.getIdentificationNumber();
    }

    public boolean checkPassword(@NotNull String password){
        // Hash the password...
        return Objects.equals(password, this.passHash);
    }
}
