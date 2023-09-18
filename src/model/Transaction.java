/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model;

import java.util.Date;
import java.util.UUID;
import java.time.*;

/**
 *
 * @author carlosforero
 */
public class Transaction {
   public enum Transactiontype{
       withdrawal,
       consignment
   }
    private String uuid;
    private Transactiontype type;
    private int amount;
    private Account account;
    private LocalDateTime datetime;
    
    public Transaction(String type,int amount,Account account){
        if(type.equals("withdrawal"))this.type = Transactiontype.withdrawal;
        if(type.equals("consignment"))this.type = Transactiontype.consignment;
        this.uuid = UUID.randomUUID().toString();
        this.account = account; 
        this.amount = amount;
        this.datetime = LocalDateTime.now();
    }
    public Transaction(String id,Transactiontype type,int amount,Account account, LocalDateTime datetime){
        this.type = type;
        this.uuid = id;
        this.amount = amount;
        this.account = account; 
        this.datetime = datetime;
    }
    public Transaction(String id,String type,int amount,Account account, LocalDateTime datetime){
        if(type.equals("withdrawal"))this.type = Transactiontype.withdrawal;
        if(type.equals("consignment"))this.type = Transactiontype.consignment;
        this.uuid = id;
        this.amount = amount;
        this.account = account; 
        this.datetime = datetime;
    }
    public String get_uuid(){
        return this.uuid;
    }
    public Transactiontype get_type(){
        return this.type;
    }
    public int get_amount(){
        return this.amount;
    }
    public Account get_account(){
        return this.account;
    }
    public LocalDateTime get_datetime(){
        return this.datetime;
    }
    
}
