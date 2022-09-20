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
//    public void setClientes(String name, String email, String phone) {
//        this.clientes.add(new Cliente(name, email, phone));
//    }

    public void setSbClientes(StringBuilder sbClientes) {
        this.sbClientes = sbClientes;
    }
    
    //methods
    public void detokenize() {
        clientes.clear();
        sbClientes.setLength(0);
        setArquivo("Open", "Clientes.txt");
        if(ler() == true) {
            String aux = getTexto();
        
            StringTokenizer tokens = new StringTokenizer(aux, ";");

            int i = 0;   
            while(tokens.hasMoreTokens()) {
                if(tokens.countTokens() == 1) {
                    break;
                } else {
                    clientes.add(i, new Cliente(Integer.valueOf(tokens.nextToken()), tokens.nextToken(), tokens.nextToken(), tokens.nextToken()));
                    i++;
                }
            }
        }
    }
    
    public void readCliente() {
        detokenize();
        
        for(Cliente cliente : clientes) {
            sbClientes
                    .append("ID: ")
                    .append(cliente.getIdCliente())
                    .append("\n")
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
    
    public void registerCliente(String name, String email, String phone, boolean appendFile) {
        detokenize();
        if(clientes.isEmpty()) {
            clientes.add(new Cliente(1, name, email, phone));
        }
        else {
            clientes.add(new Cliente(clientes.get(clientes.size() - 1).getIdCliente() + 1, name, email, phone));
        }
        String aux = clientes.get((clientes.size() - 1)).getIdCliente()+ ";" + clientes.get((clientes.size() - 1)).getName() + ";" + clientes.get((clientes.size() - 1)).getEmail() + ";" + clientes.get((clientes.size() - 1)).getPhone() + ";";
        setTexto(aux);
        getArquivo();
        escrever(appendFile);
    }
    
    public void deleteCliente(String idCliente) {
        detokenize();
        int i = 0;
        for(Cliente cliente : clientes) {
            try {
                if(clientes.get(i).getIdCliente() == Integer.valueOf(idCliente)) {
                    clientes.remove(i);
                    break;
                }
            } catch(Exception e ) {
                System.out.println("Error: Customer not removed.");         
            }
            i++;
        }
        
        setTexto("");
        getArquivo();
        escrever(false);
        
        for(Cliente cliente : clientes) {
            sbClientes
                    .append(cliente.getIdCliente())
                    .append(";")
                    .append(cliente.getName())
                    .append(";")
                    .append(cliente.getEmail())
                    .append(";")
                    .append(cliente.getPhone())
                    .append(";");
        }
        
        setTexto(sbClientes.toString());
        getArquivo();
        escrever(true);
    }
    
    public void updateCliente() {
        //todo
    }
    
    public void searchCliente(String idCliente) {
        detokenize();
        int i = 0;
        for(Cliente cliente : clientes) {
            try {
                if(clientes.get(i).getIdCliente() == Integer.valueOf(idCliente)) {
                    sbClientes
                        .append("ID: ")
                        .append(cliente.getIdCliente())
                        .append("\n")
                        .append("Name: ")
                        .append(cliente.getName())
                        .append("\n")
                        .append("Email: ")
                        .append(cliente.getEmail())
                        .append("\n")
                        .append("Phone: ")
                        .append(cliente.getPhone())
                        .append("\n\n");
                    break;
                }
            } catch(Exception e ) {
                System.out.println("Error: Customer not found.");         
            }
            i++;
        }
    }
}
