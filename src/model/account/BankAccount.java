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

    public final int accountID;
    public final User<Entity> owner;

    protected int overdraftLimit = 0;
    protected int transactionLimit = 0;
    protected int withdrawLimit = 0;
    protected int debt = 0;

    protected int balance = 0;
    protected int transactionsThisDay = 0;

    protected List<Registry<Transaction, Status, Object>> history = new ArrayList<>();

    protected BankAccount(User<Entity> owner, AccountType type) {
        this.owner = owner;
        this.accountID = generateAccountID(type);
    }
    public List<String> toList(){
        List<String> data = new ArrayList<>();
        data.add(String.valueOf(this.accountID));

        data.add(String.valueOf(this.overdraftLimit));
        data.add(String.valueOf(this.transactionLimit));
        data.add(String.valueOf(this.withdrawLimit));
        data.add(String.valueOf(this.debt));

        data.add(String.valueOf(this.balance));
        data.add(String.valueOf(this.transactionsThisDay));


        return data;
    }

    public Registry<Transaction, Status, Object> doTransaction(Transaction transaction, int value){
        if(this.transactionsThisDay >= this.transactionLimit){
            return new Registry<>(
                    transaction,
                    Status.REJECTED,
                    "Max transactions per day reached.");
        }

        Status status = Status.PROCESSING;
        String explanation = "";

        switch (transaction) {
            case DEPOSIT -> {
                Pair<Status, String> result = this.deposit(value);
                status = result.getFirst();
                explanation = result.maybeGetSecond().orElse("");
            }
            case WITHDRAW -> {
                Pair<Status, String> result = this.withdraw(value);
                status = result.getFirst();
                explanation = result.maybeGetSecond().orElse("");
            }
            case CONSULT_BALANCE -> {
                Pair<Status, Integer> result = this.getBalance();
                status = result.getFirst();
                int balance = result.maybeGetSecond().orElse(-1);

                if(balance <= -1){
                    explanation = "Something went wrong.";
                }
            }
            case CONSULT_HISTORY -> {
                Pair<Status, List<Registry<Transaction, Status, Object>>>
                        result = this.getHistory();

                status = result.getFirst();
                List<Registry<Transaction, Status, Object>>
                        history = result.maybeGetSecond().orElse(new ArrayList<>());
            }
            default -> {
                status = Status.REJECTED;
                explanation = "The transaction requested is not available.";
            }
        }

        return new Registry<>(
                transaction,
                status,
                explanation
        );
    }
    public Registry<Transaction, Status, Object> doTransaction(Transaction transaction){
        return this.doTransaction(transaction, 0);
    }

    public Pair<Status, Integer> getBalance() {
        return Pair.make(Status.APPROVED, this.balance);
    }
    public Pair<Status, String> deposit(int amount){
        if(amount <= transactionLimit && amount > 0){
            this.balance += amount;
            return Pair.make(Status.APPROVED, null);
        }
        
        String reason = "";
        
        if(amount > transactionLimit){
            reason = "Max amount of transactions per day reached.";
        } else if (amount <= 0){
            reason = "The amount to deposit is not valid.";
        }
        
        return Pair.make(Status.REJECTED, reason);

    }
    public Pair<Status, String> withdraw(int amount){
        String message = null;

        if(amount <= withdrawLimit && amount > 0){
            int toWithdraw = amount;

            if(amount >= this.balance && amount <= this.overdraftLimit){
                int newOverdraftLimit = this.balance + this.overdraftLimit - amount;
                this.debt = this.overdraftLimit - newOverdraftLimit;
                this.overdraftLimit = newOverdraftLimit;
                toWithdraw = balance;

                message = "Transaction with overdraft: " + this.debt + "COP";
            }

            this.balance -= toWithdraw;
            return Pair.make(Status.APPROVED, message);
        }

        if(amount <= 0){
            message = "The amount to withdraw is not valid.";
        } else if(amount > this.overdraftLimit) {
            message = "The amount to withdraw surpasses the overdraft limit.";
        }

        return Pair.make(Status.APPROVED, message);
    }
    public Pair<Status, List<Registry<Transaction, Status, Object>>> getHistory(){
        return Pair.make(Status.APPROVED, this.history);
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
