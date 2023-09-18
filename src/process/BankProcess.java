/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package process;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import model.Account;
import model.Bank;
import model.Client;
import model.Employee;
import model.Transaction;
import model.User;
import model.Transaction.Transactiontype;

/**
 *
 * @author carlosforero
 */
public class BankProcess {
    
    
    public static void init_bank(){
        database.createTablesIfNotExist();
    }
    public static Boolean validate_login(String username,String password){
  
        String new_pass = PasswordEncryption.encryptPassword(password);
        HashMap<String,Employee> Employees  = database.get_Employees();
    
        Employee usuario_ingresado = Employees.get(username);
        if (usuario_ingresado != null) return usuario_ingresado.Validate_password(new_pass);
        else return false;
    }
    public static Boolean Create_client(String identification, String first_name,String last_name,String type ){
        try{
            database.add_Client(new Client(identification,first_name,last_name,type));
        }
        catch(Exception e){
            System.out.println(e.toString());
            return false;
        }
        
        return true;
    }
    public static Boolean Create_account(String id_client, int limit_per_day,int limit_per_amount,int overdraft ){
        try{
            System.out.println(id_client);
            HashMap<String,Client> clients = get_Clients();
            Client client = clients.get(id_client);
            database.add_Account(new Account(client,limit_per_day,limit_per_amount,overdraft));
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("Fail1");
            return false;
        }
        
        return true;
    }
    public static Boolean Create_transaction(String id_account, String type,int amount ){
        try{
            System.out.println(id_account);
            HashMap<String,Account> clients = get_Accounts();
            Account acount = clients.get(id_account);
            System.out.println(type);
            database.add_Transaction(new Transaction(type,amount,acount));
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            
            return false;
        }
        
        return true;
    }
    public static Boolean Create_employee(String identification, String first_name,String lastname,String type, String username,String password){
        try{
            String new_pass = PasswordEncryption.encryptPassword(password);
            System.out.println("contraseña recibida:"+password+" contraseña cifrada:"+new_pass );
            database.add_Empoloyee(new Employee( identification,  first_name, lastname, type,  username, new_pass));
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            
            return false;
        }
        
        return true;
    }
    
    public static HashMap<String,Client> get_Clients(){
        return database.get_Client();
    }
    public static HashMap<String,Employee> get_Employee(){
        return database.get_Employees();
    }
    public static HashMap<String,Account> get_Accounts(){
        return database.get_Accounts();
    }
    public static HashMap<String,Transaction> get_Transactions(){
        return database.get_Transactions();
    }
    public static int get_balence_by_account(String account_id){
        HashMap<String,Transaction> transactions = database.get_Transactions();
        int balance = 0;
        for (Map.Entry<String, Transaction> entry : transactions.entrySet()) {
            System.out.println(entry.getValue().get_amount()+" "+entry.getValue().get_type().toString());
            if(entry.getValue().get_account().get_numberAccount() == null ? account_id == null : entry.getValue().get_account().get_numberAccount().equals(account_id)){
                {
                if(entry.getValue().get_type().toString().equals("withdrawal"))balance -= entry.getValue().get_amount();
                if(entry.getValue().get_type().toString().equals("consignment"))balance += entry.getValue().get_amount();
               
                }
            }
        }
        return balance;
    }
    public static int count_withdrawal_in_day(String account_id){
        HashMap<String,Transaction> transactions = database.get_Transactions();
        int counter = 0;
        for (Map.Entry<String, Transaction> entry : transactions.entrySet()) {
            System.out.println(entry.getValue().get_amount()+" "+entry.getValue().get_type().toString());
            if(entry.getValue().get_account().get_numberAccount() == null ? account_id == null : entry.getValue().get_account().get_numberAccount().equals(account_id)){
                {
                if(entry.getValue().get_type().toString().equals("withdrawal") && entry.getValue().get_datetime().getDayOfMonth() == LocalDateTime.now().getDayOfMonth())counter +=1;
                
               
                }
            }
        }
        return counter;
    }
    
}
