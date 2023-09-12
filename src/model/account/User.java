package model.account;

abstract public class User {
    protected final int UserID;
    protected final int hash;

    public User(int userID) {
        this.UserID = userID;
        this.hash = 0; // Read from file
    }
}
