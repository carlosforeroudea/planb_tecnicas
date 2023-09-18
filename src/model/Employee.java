/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


/**
 *
 * @author carlosforero
 */
public class Employee implements User {
     public enum EmployeeType{
         Taquilleros,
         Jefe_de_sucursal,
         Gerente
     }
    protected String id;
    protected String first_name;
    protected String last_name;
    private EmployeeType type;
    private String password;
    private String username;
    
     @Override
    public String get_first_name(){
        return this.first_name;
    }
     @Override
    public String get_last_name(){
        return this.last_name;
    }
     @Override
    public String get_id(){
        return this.id;
    }    
    public Employee(){
    
    }
    public Employee(String username){
        this.username = username;
    }
    public Employee(String username,String password,EmployeeType type){
        this.username = username;
        this.password = password;
        this.type = type;
    }
    public Employee(String identification, String first_name,String last_name,String type,String username,String password){
        if(type.equals("Taquilleros"))this.type = EmployeeType.Taquilleros;
        if(type.equals("Gerente"))this.type = EmployeeType.Gerente;
        if(type.equals("Jefe_de_sucursal"))this.type = EmployeeType.Jefe_de_sucursal;
        this.id = identification;
        this.first_name  = first_name;
        this.last_name = last_name;
        this.password = password;
        this.username = username;   
    }
    public String get_username(){
        return this.username;
    }
    public Boolean Validate_password(String password){
        return (this.password == null ? password == null : this.password.equals(password));
    }
    public EmployeeType get_type(){
        return this.type;
    }
    public String get_password(){
        return this.password;
    }
}