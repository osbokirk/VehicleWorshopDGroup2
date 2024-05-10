package org.example;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DealershipFileManager {

    private String dealershipName;

    public DealershipFileManager(String dealershipName){
        this.dealershipName = dealershipName;
    }

    public void saveVehicles(List<Vehicle> vehicles) {
       try {
           FileWriter writer = new FileWriter("vehicles.txt");
           for (Vehicle vehicle : vehicles){
               writer.write(vehicle.toString() + "\n");

           }
           writer.close();
       } catch (IOException e){


       }
    }

    public void updateVehicle(Vehicle vehicle) {

    }

    public void deleteVehicle(int vin) {

    }
}




