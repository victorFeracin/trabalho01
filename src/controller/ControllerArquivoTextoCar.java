/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.StringTokenizer;
import model.Car;

/**
 *
 * @author Victor Hugo
 */
public class ControllerArquivoTextoCar extends ControllerArquivoTexto {
        
    protected ArrayList<Car> cars = new ArrayList<>();
    protected StringBuilder sbCars = new StringBuilder();
    
    //getters
    public ArrayList<Car> getCars() {
        return cars;
    }

    public StringBuilder getSbCars() {
        return sbCars;
    }
      
    //setters
    public void setSbCars(StringBuilder sbCars) {
        this.sbCars = sbCars;
    }
    
    //methods
    public void detokenize() {
        cars.clear();
        sbCars.setLength(0);
        getArquivo();
        if(ler() == true) {
            String aux = getTexto();
        
            StringTokenizer tokens = new StringTokenizer(aux, ";");

            int i = 0;   
            while(tokens.hasMoreTokens()) {
                if(tokens.countTokens() == 1) {
                    break;
                } else {
                    cars.add(i, new Car(Integer.valueOf(tokens.nextToken()), tokens.nextToken(), Integer.valueOf(tokens.nextToken()), tokens.nextToken(), Double.valueOf(tokens.nextToken())));
                    i++;
                }
            }
        }
    }
    
    public void readCar() {
        detokenize();
        
        for(Car car : cars) {
            sbCars
                    .append("ID: ")
                    .append(car.getIdCar())
                    .append("\n")
                    .append("Name: ")
                    .append(car.getName())
                    .append("\n")
                    .append("Year: ")
                    .append(car.getYear())
                    .append("\n")
                    .append("Brand: ")
                    .append(car.getBrand())
                    .append("\n")
                    .append("Price: ")
                    .append(car.getPrice())
                    .append("\n\n");
        }
    }
    
    public void registerCar(String name, int year, String brand, double price, boolean appendFile) {
        detokenize();
        if(cars.isEmpty()) {
            cars.add(new Car(1, name, year, brand, price));
        }
        else {
            cars.add(new Car(cars.get(cars.size() - 1).getIdCar() + 1, name, year, brand, price));
        }
        String aux = cars.get((cars.size() - 1)).getIdCar()+ ";" + cars.get((cars.size() - 1)).getName() + ";" + cars.get((cars.size() - 1)).getYear() + ";" + cars.get((cars.size() - 1)).getBrand() + ";" + cars.get((cars.size() - 1)).getPrice() + ";";
        System.out.println("AUX: " + aux);
        setTexto(aux);
        getArquivo();
        escrever(appendFile);
    }
    
    public void deleteCar(String idCar) {
        detokenize();
        int i = 0;
        for(Car car : cars) {
            try {
                if(cars.get(i).getIdCar() == Integer.valueOf(idCar)) {
                    cars.remove(i);
                    break;
                }
            } catch(Exception e ) {
                System.out.println("Error: Car not removed.");         
            }
            i++;
        }
        
        setTexto("");
        getArquivo();
        escrever(false);
        
        for(Car car : cars) {
            sbCars
                    .append(car.getIdCar())
                    .append(";")
                    .append(car.getName())
                    .append(";")
                    .append(car.getYear())
                    .append(";")
                    .append(car.getBrand())
                    .append(";")
                    .append(car.getPrice())
                    .append(";");
        }
        
        setTexto(sbCars.toString());
        getArquivo();
        escrever(true);
    }
    
    public void updateCar(String idCar, String name, int year, String brand, double price) {
        detokenize();
        int i = 0;
        for(Car car : cars) {
            try {
                if(cars.get(i).getIdCar() == Integer.valueOf(idCar)) {
                    car.setName(name);
                    car.setYear(year);
                    car.setBrand(brand);
                    car.setPrice(price);
                    break;
                    
                }
            } catch(Exception e) {
                System.out.println("Error: Could not update car.");
            }
            i++;
        }
        
        for(Car car : cars) {
            sbCars
                    .append(car.getIdCar())
                    .append(";")
                    .append(car.getName())
                    .append(";")
                    .append(car.getYear())
                    .append(";")
                    .append(car.getBrand())
                    .append(";")
                    .append(car.getPrice())
                    .append(";");
        }
        
        setTexto(sbCars.toString());
        getArquivo();
        escrever(false);
    }
    
    public void searchCar(String idCar) {
        detokenize();
        int i = 0;
        for(Car car : cars) {
            try {
                if(cars.get(i).getIdCar() == Integer.valueOf(idCar)) {
                    sbCars
                        .append("ID: ")
                        .append(car.getIdCar())
                        .append("\n")
                        .append("Name: ")
                        .append(car.getName())
                        .append("\n")
                        .append("Year: ")
                        .append(car.getYear())
                        .append("\n")
                        .append("Brand: ")
                        .append(car.getBrand())
                        .append("\n")
                        .append("Price: ")
                        .append(car.getPrice())
                        .append("\n\n");
                    break;
                }
            } catch(Exception e ) {
                System.out.println("Error: Car not found.");         
            }
            i++;
        }
    }
}
