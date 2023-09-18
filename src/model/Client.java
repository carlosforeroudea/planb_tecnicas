/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author carlosforero
 */
public class Client implements User{
    public enum ClientType{
         personas_naturales,personas_jurídicas
         
     }
     protected String id;
    protected String first_name;
    protected String last_name;
    
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
    
    private ClientType clientType; 
    public Client(String firstname, String lastname, ClientType type){
        this.first_name = firstname;
        this.last_name = lastname;
        this.clientType = type;
    }
    public ClientType get_type(){
        return this.clientType;
    }
    public Client(String id,String first_name, String last_name, String type){
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        switch(type){
            case "personas_naturales":
                this.clientType = ClientType.personas_naturales;
            case "personas_jurídicas":
                this.clientType = ClientType.personas_jurídicas;
            default:
                this.clientType = ClientType.personas_naturales;
        }
    }
}
