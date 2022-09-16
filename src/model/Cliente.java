/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Victor Hugo
 */
public class Cliente {
    private int idCliente;
    private String name;
    private String email;
    private String phone;
    
    
    //Getters
    public int getIdCliente() {
        return idCliente;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
    
    
    //Setters
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    //constructor
    public Cliente() {
        
    }

    public Cliente(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
}
