/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;


import java.util.ArrayList;
import java.util.StringTokenizer;
import model.Cliente;

/**
 *
 * @author Victor Hugo
 */
public class ControllerArquivoTextoCliente extends ControllerArquivoTexto {
    
    protected ArrayList<Cliente> clientes = new ArrayList<>();
    protected StringBuilder sbClientes = new StringBuilder();
    
    //getters
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public StringBuilder getSbClientes() {
        return sbClientes;
    }
    
    //setters
    public void setClientes(String name, String email, String phone) {
        this.clientes.add(new Cliente(name, email, phone));
    }

    public void setSbClientes(StringBuilder sbClientes) {
        this.sbClientes = sbClientes;
    }
    
    //methods
    public void readCliente() {
        setArquivo("Open", "Clientes.txt");
        ler();
        String aux = getTexto();
        
        StringTokenizer tokens = new StringTokenizer(aux, ";");
        
        int i = 0;   
        while(tokens.hasMoreTokens()) {
            if(tokens.countTokens() == 1) {
                break;
            } else {
                clientes.add(i, new Cliente(tokens.nextToken(), tokens.nextToken(), tokens.nextToken()));
                i++;
            }
        }
        
        for(Cliente cliente : clientes) {
            sbClientes
                    .append("Name: ")
                    .append(cliente.getName())
                    .append("\n")
                    .append("Email: ")
                    .append(cliente.getEmail())
                    .append("\n")
                    .append("Phone: ")
                    .append(cliente.getPhone())
                    .append("\n\n");
        }
    }
    
    public void registerCliente() {
        String aux = clientes.get((clientes.size() - 1)).getName() + ";" + clientes.get((clientes.size() - 1)).getEmail() + ";" + clientes.get((clientes.size() - 1)).getPhone() + ";";
        setTexto(aux);
        setArquivo("Salvar", "Clientes.txt");
        escrever(true);
    }
    
    public void deleteCliente() {
        //todo
    }
    
    public void updateCliente() {
        //todo
    }
}
