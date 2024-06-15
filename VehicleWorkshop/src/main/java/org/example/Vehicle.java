package org.example;

public class Vehicle {
    private String vin;
    private int year;
    private String model; 
    private String make;
    private String vehicleType;
    private String color;
    private int odometer;
    private double price;

    public Vehicle(String vin, int year, String make, String model, String vehicleType,String color , int odometer, double price) {
        this.vin = vin;
        this.year = year;
        this.model = model;
        this.make = make;
        this.color = color;
        this.vehicleType = vehicleType;
        this.odometer = odometer;
        this.price = price;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public String toString() {
        return String.format("%s|%d|%s|%s|%s|%s|%d|%.2f",
                vin, year, make, model, vehicleType, color, odometer, price);
    }
}
