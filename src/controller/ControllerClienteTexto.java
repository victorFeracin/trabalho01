/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;

/**
 *
 * @author Victor Hugo
 */
public class ControllerClienteTexto {
    
    protected File arq = null;
    private String text;
    private BufferedReader reader = null;
    private BufferedWriter writer = null;
    
    //getters
    public String getText() {
        return text;
    }
    
    public File getArq() {
        return arq;
    }

    //setters
    public void setText(String text) {
        this.text = text;
    }
    
    public void setArq(String TextButton) {
        arq = null;
        String initialFolder = System.getProperty("user.dir");
        JFileChooser chooser = new JFileChooser(initialFolder);
        if (chooser.showDialog(null, TextButton) == JFileChooser.APPROVE_OPTION) {
            arq = chooser.getSelectedFile();
        }     
    }
    
    public boolean read() {
        StringBuilder line = new StringBuilder();
        try {
            reader = new BufferedReader(new FileReader(arq));
            while (reader.ready()) {
                line.append(reader.readLine()).append("\n");
            }
            reader.close();
            setText(line.toString());
            return true;
        } catch (FileNotFoundException error) {
            System.err.println(error.getMessage() + "Error while retrieving informations.");
            return false;
        } catch (IOException error) {
            System.err.println(error.getMessage() + "Error while retrieving informations.");
            return false;
        }
    }
}
