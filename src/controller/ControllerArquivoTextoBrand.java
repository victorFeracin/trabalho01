/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.StringTokenizer;
import model.Brand;

/**
 *
 * @author Victor Hugo
 */
public class ControllerArquivoTextoBrand extends ControllerArquivoTexto {
        
    protected ArrayList<Brand> brands = new ArrayList<>();
    protected StringBuilder sbBrands = new StringBuilder();
    
    //getters
    public ArrayList<Brand> getBrands() {
        return brands;
    }

    public StringBuilder getSbBrands() {
        return sbBrands;
    }
      
    //setters
    public void setSbBrands(StringBuilder sbBrands) {
        this.sbBrands = sbBrands;
    }
    
    //methods
    public void detokenize() {
        brands.clear();
        sbBrands.setLength(0);
        getArquivo();
        if(ler() == true) {
            String aux = getTexto();
        
            StringTokenizer tokens = new StringTokenizer(aux, ";");

            int i = 0;   
            while(tokens.hasMoreTokens()) {
                if(tokens.countTokens() == 1) {
                    break;
                } else {
                    brands.add(i, new Brand(Integer.valueOf(tokens.nextToken()), tokens.nextToken(), Integer.valueOf(tokens.nextToken()), tokens.nextToken()));
                    i++;
                }
            }
        }
    }
    
    public void readBrand() {
        detokenize();
        
        for(Brand brand : brands) {
            sbBrands
                    .append("ID: ")
                    .append(brand.getIdBrand())
                    .append("\n")
                    .append("Name: ")
                    .append(brand.getName())
                    .append("\n")
                    .append("Year of creation: ")
                    .append(brand.getYearCreated())
                    .append("\n")
                    .append("Website: ")
                    .append(brand.getWebsite())
                    .append("\n\n");
        }
    }
    
    public void registerBrand(String name, int yearCreated, String website, boolean appendFile) {
        detokenize();
        if(brands.isEmpty()) {
            brands.add(new Brand(1, name, yearCreated, website));
        }
        else {
            brands.add(new Brand(brands.get(brands.size() - 1).getIdBrand() + 1, name, yearCreated, website));
        }
        String aux = brands.get((brands.size() - 1)).getIdBrand()+ ";" + brands.get((brands.size() - 1)).getName() + ";" + brands.get((brands.size() - 1)).getYearCreated() + ";" + brands.get((brands.size() - 1)).getWebsite() + ";";
        setTexto(aux);
        getArquivo();
        escrever(appendFile);
    }
    
    public void deleteBrand(String idBrand) {
        detokenize();
        int i = 0;
        for(Brand brand : brands) {
            try {
                if(brands.get(i).getIdBrand() == Integer.valueOf(idBrand)) {
                    brands.remove(i);
                    break;
                }
            } catch(Exception e ) {
                System.out.println("Error: Brand not removed.");         
            }
            i++;
        }
        
        setTexto("");
        getArquivo();
        escrever(false);
        
        for(Brand brand : brands) {
            sbBrands
                    .append(brand.getIdBrand())
                    .append(";")
                    .append(brand.getName())
                    .append(";")
                    .append(brand.getYearCreated())
                    .append(";")
                    .append(brand.getWebsite())
                    .append(";");
        }
        
        setTexto(sbBrands.toString());
        getArquivo();
        escrever(true);
    }
    
    public void updateBrand(String idBrand, String name, int yearCreated, String website) {
        detokenize();
        int i = 0;
        for(Brand brand : brands) {
            try {
                if(brands.get(i).getIdBrand() == Integer.valueOf(idBrand)) {
                    brand.setName(name);
                    brand.setYearCreated(yearCreated);
                    brand.setWebsite(website);
                    break;
                    
                }
            } catch(Exception e) {
                System.out.println("Error: Could not update brand.");
            }
            i++;
        }
        
        for(Brand brand : brands) {
            sbBrands
                    .append(brand.getIdBrand())
                    .append(";")
                    .append(brand.getName())
                    .append(";")
                    .append(brand.getYearCreated())
                    .append(";")
                    .append(brand.getWebsite())
                    .append(";");
        }
        
        setTexto(sbBrands.toString());
        getArquivo();
        escrever(false);
    }
    
    public void searchBrand(String idBrand) {
        detokenize();
        int i = 0;
        for(Brand brand : brands) {
            try {
                if(brands.get(i).getIdBrand() == Integer.valueOf(idBrand)) {
                    sbBrands
                        .append("ID: ")
                        .append(brand.getIdBrand())
                        .append("\n")
                        .append("Name: ")
                        .append(brand.getName())
                        .append("\n")
                        .append("Year of creation: ")
                        .append(brand.getYearCreated())
                        .append("\n")
                        .append("Website: ")
                        .append(brand.getWebsite())
                        .append("\n\n");
                    break;
                }
            } catch(Exception e ) {
                System.out.println("Error: brand not found.");         
            }
            i++;
        }
    }
}
