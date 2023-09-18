/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.HashMap;
import java.util.UUID;

/**
 *
 * @author carlosforero
 */
public class Account {
    private Client client;
    private String number;
    private HashMap<String,Transaction> transactions ;
    private int limit_per_day;
    private int limit_per_amount;
    private int overdraft;
    
    public Account(Client client,int limit_per_day,int limit_per_amount, int overdraft){
        this.client = client;
        this.number = UUID.randomUUID().toString();
        this.transactions = new HashMap<>();
        this.limit_per_day = limit_per_day;
        this.limit_per_amount = limit_per_amount;
        this.overdraft = overdraft;
    }
    public Account(String number,Client client,int limit_per_day,int limit_per_amount, int overdraft){
        this.client = client;
        this.number = number;
        this.transactions = new HashMap<>();
        this.limit_per_day = limit_per_day;
        this.limit_per_amount = limit_per_amount;
        this.overdraft = overdraft;
    }
    public Account(String number,Client client,HashMap<String,Transaction> transaction,int limit_per_day,int limit_per_amount, int overdraft){
        this.client = client;
        this.number = number;
        this.transactions = transaction;
        this.limit_per_day = limit_per_day;
        this.limit_per_amount = limit_per_amount;
        this.overdraft = overdraft;
    }
    public Client get_client(){
        return this.client;
    }
    public String get_numberAccount(){
        return this.number;
    }
    public int get_limit_per_day(){
        return this.limit_per_day;
    }
    public int get_limit_per_amount(){
        return this.limit_per_amount;
    }
    public int get_overdraft(){
        return this.overdraft;
    }
    public HashMap<String,Transaction> get_transactions(){
        return this.transactions;
    }
}
