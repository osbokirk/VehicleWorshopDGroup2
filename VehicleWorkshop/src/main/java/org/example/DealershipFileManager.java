package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DealershipFileManager {

    private String dealershipName;

    public DealershipFileManager(String dealershipName){
        this.dealershipName = dealershipName;
    }

    public static void saveDealership(Dealership dealership) {
        try {
            FileWriter writer = new FileWriter("src/main/resources/inventory.csv");
            BufferedWriter writer1 = new BufferedWriter(writer);
            writer1.write(dealership.getName()+"\\|"+dealership.getAddress()+"\\|"+dealership.getPhone()+"\n");
            for (Vehicle x : dealership.getAllVehicles()){
                writer1.write(x + "\n");
            }
            writer1.close( );
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static Dealership getDealership(){
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/inventory.csv"))){
            String line  = reader.readLine();
            String[] dealershipInfo = line.split("\\|");
            Dealership dealership = new Dealership(dealershipInfo[0],dealershipInfo[1],dealershipInfo[2]);
            ArrayList<Vehicle> cars = new ArrayList<>();
            String carValues;
            while((carValues = reader.readLine()) != null){
                String[] values = carValues.split("\\|");
                cars.add(new Vehicle(Integer.parseInt(values[0]),Integer.parseInt(values[1]),values[2],values[3],values[4],values[5],Integer.parseInt(values[6]),Double.parseDouble(values[7])));
            }
            dealership.setInventory(cars);
            return dealership;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


class Car {
    private int vin;
    private int year;
    private String make;
    private String model;
    private String type;
    private String color;
    private int mileage;
    private double price;

    public void Vehicle(int vin, int year, String make, String model, String type, String color, int mileage, double price) {
        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model = model;
        this.type = type;
        this.color = color;
        this.mileage = mileage;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%d|%d|%s|%s|%s|%s|%d|%.2f",
                vin, year, make, model, type, color, mileage, price);
    }
}


