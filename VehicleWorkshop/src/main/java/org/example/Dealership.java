package org.example;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private int DealershipID = 1;//should point to a specific dealership in database
    private DealershipRepository dealershipRepository = new DealershipRepository( "jdbc:mysql://localhost:3306/dealership","root","YUm15510n");




    //for multi dealership use add dealershipID to constructor
    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }





    public List<Vehicle> getVehiclesByPrice(double min,double max){
//        List<Vehicle> tempList = new ArrayList<>();
//        for (Vehicle x : inventory){
//            if (x.getPrice() <= max && x.getPrice() >= min){
//                tempList.add(x);
//            }
//        }
//        return tempList;
        return dealershipRepository.ByPriceRange(min,max,DealershipID);
    }
    public List<Vehicle> getVehiclesByMakeModel(String make,String model){
//        ArrayList<Vehicle> tempList = new ArrayList<>();
//        for(Vehicle v : inventory){
//            if (v.getMake().toLowerCase().contains(make.toLowerCase())
//                    && v.getModel().toLowerCase().contains(model.toLowerCase())){
//                tempList.add(v);
//            }
//        }
//        return tempList;
        return dealershipRepository.ByMakeModel(make,model,DealershipID);
    }
    public List<Vehicle> getVehiclesByYear(int min, int max){
//        List<Vehicle> tempList = new ArrayList<>();
//        for (Vehicle x : inventory){
//            if (x.getYear() <= max && x.getYear() >= min){
//                tempList.add(x);
//            }
//        }
//        return tempList;
        return dealershipRepository.ByYear(min,max,DealershipID);
    }
    public List<Vehicle> getVehiclesByColor(String color){
//        List<Vehicle> tempList = new ArrayList<>();
//        if (color != null && !color.isEmpty()) {
//            for (Vehicle x : inventory) {
//                if (x.getVehicleType().toLowerCase().equals(color.toLowerCase())) {
//                    tempList.add(x);
//                }
//            }
//            return tempList;
//        }
//        else {
//            return new ArrayList<>(inventory);
//        }
        return dealershipRepository.ByColor(color,DealershipID);
    }
    public List<Vehicle> getVehiclesByMileage(int min,int max){
//        List<Vehicle> tempList = new ArrayList<>();
//        for (Vehicle x : inventory){
//            if (x.getPrice() <= max && x.getPrice() >= min){
//                tempList.add(x);
//            }
//        }
//        return tempList;
        return dealershipRepository.ByMileage(min,max,DealershipID);
    }
    public List<Vehicle> getVehiclesByType(String type){
//        List<Vehicle> tempList = new ArrayList<>();
//        if (type != null && !type.isEmpty()) {
//            for (Vehicle x : inventory) {
//                if (x.getVehicleType().toLowerCase().equals(type.toLowerCase())) {
//                    tempList.add(x);
//                }
//            }
//            return tempList;
//        }
//        else {
//            return new ArrayList<>(inventory);
//        }
        return dealershipRepository.ByType(type,DealershipID);
    }

    public List<Vehicle> getAllVehicles(){
        return dealershipRepository.GetAll(DealershipID);
    }
    public void addVehicle(Vehicle vehicle){
        if (vehicle == null){
            System.out.println("Sorry, cannot add a null vehicle.");
        }
        else if (!dealershipRepository.GetAll(DealershipID).contains(vehicle)){
            //inventory.add(vehicle);
            dealershipRepository.addVehicle(vehicle,DealershipID);
            System.out.println("Vehicle added successfully");
        }
        else {

            System.out.println("Sorry, this vehicle is already in the inventory.");
            // DealershipFileManager.Save(): // Uncomment when FileManager is ready
        }

    }
    public void removeVehicle(Vehicle vehicle) {
        if (vehicle == null || !dealershipRepository.GetAll(DealershipID).contains(vehicle)) {
            System.out.println("Sorry, Vehicle Could Not be Found");
        } else {
            //inventory.remove(vehicle);
            dealershipRepository.removeVehicle(vehicle);
            System.out.println("Vehicle removed successfully.");
            // DealershipFileManager.save(); // Uncomment when FileManager is ready
        }
    }
    public String toString(){
        String output = "";
        for (Vehicle x : dealershipRepository.GetAll(DealershipID)){
            output.concat(x+"\n");
        }

        return output;
    }
}
