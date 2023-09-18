/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package process;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import model.Account;
import model.Client;
import model.Employee;
import model.Transaction;
import model.User;

    class database
    {
       protected static void add_Empoloyee(Employee new_user){
           Connection connection = null;
           try
           {
                connection = DriverManager.getConnection("jdbc:sqlite:data_bank.db");
                Statement statement = connection.createStatement();
                statement.executeUpdate("insert into Employee (id,password,username,first_name,last_name,EmployeeType) values('"+new_user.get_id() +"','"+new_user.get_password()+"','"+new_user.get_username()+"','"+new_user.get_first_name()+"','"+new_user.get_last_name()+"','"+new_user.get_type().toString()+"')");
           }
           catch(SQLException e){
               System.out.println(e.toString());
           }        
       }
       protected static void add_Client(Client new_user){
           Connection connection = null;
           try
           {
                connection = DriverManager.getConnection("jdbc:sqlite:data_bank.db");
                Statement statement = connection.createStatement();
                String query = "INSERT INTO Client (id,first_name ,last_name,Clienttype) values ('"+new_user.get_id()+"','"+new_user.get_first_name()+"','"+new_user.get_last_name()+"','"+new_user.get_type().toString()+"')";
                System.out.println(query);
                statement.executeUpdate(query);
           }
           catch(SQLException e){
               System.out.println(e.toString());
           }        
       }
       protected static void add_Account(Account new_account){
           Connection connection = null;
           try
           {
                connection = DriverManager.getConnection("jdbc:sqlite:data_bank.db");
                Statement statement = connection.createStatement();
                String query = "INSERT INTO Account (id,client_id ,limit_per_day,limit_per_amount,overdraft) values ('"+new_account.get_numberAccount()+"','"+new_account.get_client().get_id()+"',"+new_account.get_limit_per_day()+","+new_account.get_limit_per_amount()+","+new_account.get_overdraft()+")";
                System.out.println(query);
                statement.executeUpdate(query);
           }
           catch(SQLException e){
               System.out.println(e.toString());
           }        
       }
       protected static void add_Transaction(Transaction new_transaction){
           Connection connection = null;
           try
           {
                connection = DriverManager.getConnection("jdbc:sqlite:data_bank.db");
                Statement statement = connection.createStatement();
                String query = "INSERT INTO Transactions (typet,uuid ,amount,account_id,datetime) values ('"+new_transaction.get_type().toString()+"','"+new_transaction.get_uuid()+"',"+new_transaction.get_amount()+",'"+new_transaction.get_account().get_numberAccount()+"','"+new_transaction.get_datetime()+"')";
                System.out.println(query);
                statement.executeUpdate(query);
           }
           catch(SQLException e){
               System.out.println(e.toString());
           }        
       }
       
       protected static HashMap<String,Employee> get_Employees(){
           Connection connection = null;
           HashMap<String,Employee> userlist = new HashMap<>(); 
           try
           {
                connection = DriverManager.getConnection("jdbc:sqlite:data_bank.db");
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("select * from Employee");
                while(rs.next())
                    {
                      userlist.put(rs.getString("username"), new Employee(rs.getString("id"),rs.getString("first_name"),rs.getString("last_name"),rs.getString("EmployeeType"),rs.getString("username"),rs.getString("password")));

                    }
           }
           catch(SQLException e){
               System.out.println(e.toString());
           }
           return userlist;
        }
       protected static HashMap<String,Client> get_Client(){
           Connection connection = null;
           HashMap<String,Client> userlist = new HashMap<>(); 
           try
           {
                connection = DriverManager.getConnection("jdbc:sqlite:data_bank.db");
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("select * from Client");
                while(rs.next())
                    {
                      userlist.put(rs.getString("id"), new Client(rs.getString("id"),rs.getString("first_name"),rs.getString("last_name"),rs.getString("ClientType")));

                    }
           }
           catch(SQLException e){
               System.out.println(e.toString());
           }
           return userlist;
        }
       protected static HashMap<String,Account> get_Accounts(){
           Connection connection = null;
           HashMap<String,Account> userlist = new HashMap<>(); 
           try
           {
                connection = DriverManager.getConnection("jdbc:sqlite:data_bank.db");
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("select * from Account");
                HashMap<String,Client> clients = get_Client();
                while(rs.next())
                    {   
                        
                        Client client = clients.get(rs.getString("client_id"));
                        userlist.put(rs.getString("id"),new Account(rs.getString("id"),client,rs.getInt("limit_per_day"),rs.getInt("limit_per_amount"),rs.getInt("overdraft")));

                    }
           }
           catch(SQLException e){
               System.out.println(e.toString());
           }
           return userlist;
        }
       protected static HashMap<String,Transaction> get_Transactions(){
           Connection connection = null;
           HashMap<String,Transaction> transaction_list = new HashMap<>(); 
           try
           {
                connection = DriverManager.getConnection("jdbc:sqlite:data_bank.db");
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("select * from Transactions");
                HashMap<String,Account> accounts = get_Accounts();
                while(rs.next())
                    {   
                        
                        Account account = accounts.get(rs.getString("account_id"));
                        transaction_list.put(rs.getString("uuid"),new Transaction(rs.getString("uuid"),rs.getString("typet"),rs.getInt("amount"),account,LocalDateTime.parse(rs.getString("datetime"))));

                    }
           }
           catch(SQLException e){
               System.out.println(e.toString());
           }
           return transaction_list;
        }
      
      protected static void createTablesIfNotExist()
      {
        Connection connection = null;
        try
        {
          // create a database connection
          connection = DriverManager.getConnection("jdbc:sqlite:data_bank.db");
          Statement statement = connection.createStatement();
          statement.setQueryTimeout(30);  // set timeout to 30 sec.
          
          statement.executeUpdate("create table IF NOT EXISTS Employee (id string, password string, username string, first_name string , last_name string,EmployeeType string)");
          statement.executeUpdate("create table IF NOT EXISTS Client (id string, ClientType string, first_name string , last_name string)");
          statement.executeUpdate("create table IF NOT EXISTS Account (id string, client_id string, limit_per_day integer , limit_per_amount integer, overdraft integer)");
          statement.executeUpdate("create table IF NOT EXISTS Transactions (uuid string, typet string, amount integer , account_id string, datetime string)");
          
 
        }
        catch(SQLException e)
        {
          // if the error message is "out of memory",
          // it probably means no database file is found
          System.err.println(e.getMessage());
        }
        finally
        {
          try
          {
            if(connection != null)
              connection.close();
          }
          catch(SQLException e)
          {
            // connection close failed.
            System.err.println(e.getMessage());
          }
        }
      }
    }