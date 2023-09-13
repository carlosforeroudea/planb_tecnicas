package model.account;

import model.entity.Person;
import model.util.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class BankAccount<Entity extends Person> {
    public static final int ID_MAX_SIZE = 10;
    public static int PREVIOUS_USER_ID = 0;
    public static int ACCOUNT_ID_COUNTER = 0;

    public final int AccountID;
    public final User<Entity> owner;

    protected int overdraftLimit = 0;
    protected int transactionLimit = 0;
    protected int withdrawLimit = 0;
    protected int debt = 0;

    protected int balance = 0;
    protected int transactionsThisDay = 0;

    protected int score = 100;

    protected List<Registry<Transaction, Object, Status>> history = new ArrayList<>();

    public BankAccount(User<Entity> owner, AccountType type) {
        this.owner = owner;
        this.AccountID = generateAccountID(type);
    }

    public Object doTransaction(Transaction transaction, int value){
        if(this.transactionsThisDay >= this.transactionLimit){
            return false;
        }

        this.transactionsThisDay++;

        return switch (transaction){
            case DEPOSIT -> this.addToBalance(value);
            case WITHDRAW -> this.withdraw(value);
            case CONSULT_BALANCE -> this.getBalance();
            case CONSULT_HISTORY -> this.getHistory();
            default -> false;
        };
    }

    public int getBalance() {
        return this.balance;
    }
    public boolean addToBalance(int amount){
        if(amount <= transactionLimit && amount > 0){
            this.balance += amount;
            return true;
        }

        return false;
    }

    public boolean withdraw(int amount){
        if(amount <= withdrawLimit && amount > 0){
            this.balance -= amount;
        }

        return false;
    }

    public List<Registry<Transaction, Object, Status>> getHistory(){
        return this.history;
    }

    public int getScore(){
        return score;
    }

    protected void updateScore(){
        
    }


    protected static int generateUserID(PersonType type){
        PREVIOUS_USER_ID++;

        int newID = type.getValue();
        newID *= 10;

        if(type == PersonType.EMPLOYEE)
            newID += EmployeeRole.CONSULTANT.ordinal() + 1;

        newID *= (int) Math.pow(10, ID_MAX_SIZE - 2);
        newID += PREVIOUS_USER_ID;

        return newID;
    }
    protected static int generateAccountID(AccountType type){
        ACCOUNT_ID_COUNTER++;

        int newID = type.getValue();

        newID *= (int) Math.pow(10, ID_MAX_SIZE);
        newID += ACCOUNT_ID_COUNTER;

        return newID;
    }

    public static <E extends Person> BankAccount<E> create(User<E> owner, AccountType type){
        return new BankAccount<>(owner, type);
    }
    public static <E extends Person> BankAccount<E> create(E entity, AccountType accountType){
        PersonType type = PersonType.byType(entity.getClass());
        int ownerID = BankAccount.generateUserID(type);
        User<E> newOwner = new User<>(ownerID, entity);
        return BankAccount.create(newOwner, accountType);
    }
    public static <E extends Person> BankAccount<E> create(Supplier<E> personSupplier, AccountType type){
        return BankAccount.create(personSupplier.get(), type);
    }

}
