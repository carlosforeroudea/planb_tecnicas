package model.bank;

import model.account.BankAccount;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    String name;
    List<Integer> accountIds = new ArrayList<>();


    public Bank(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    List<Integer> getAccountsIds(){
        return new ArrayList<>();
    }

    protected BankAccount requestAccount(int accountID){
        return null;
    }
}
