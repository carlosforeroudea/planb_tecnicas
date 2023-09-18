/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author carlosforero
 */
public class Bank {
    private String name;
    private String info;
    
    public Bank(String name, String info){
        this.name = name;
        this.info = info;
    }
    public String get_info(){
        return this.info;
    }
    public String get_name(){
        return this.name;
    }
}
