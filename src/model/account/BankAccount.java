package model.account;

import model.data.Registry;
import model.data.Status;
import model.data.Transaction;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    public final int ID = 0;
    public final User owner;

    protected int overdraftLimit = 0;
    protected int transactionLimit = 0;
    protected int withdrawLimit = 0;

    protected int balance = 0;
    protected int transactionsThisDay = 0;

    protected List<Registry<Transaction, Object, Status>> history = new ArrayList<>();

    public BankAccount(User owner) {
        this.owner = owner;
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
}
