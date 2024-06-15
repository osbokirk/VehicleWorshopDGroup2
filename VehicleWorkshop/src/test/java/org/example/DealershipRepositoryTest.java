package org.example;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DealershipRepositoryTest {
    private DealershipRepository dealershipRepository = new DealershipRepository("jdbc:mysql://localhost:3306/dealership","root","YUm15510n");
    Vehicle vehicle = new Vehicle("555444",1995,"Explorer","Ford","SUV","Red",20000,19000);
    @Test
    public void AddVehicle(){

        //arrange

        //act
        dealershipRepository.addVehicle(vehicle,1);
        //assert


    }
    @Test
    public void RemoveVehicle(){
        //arrange

        //act
        dealershipRepository.removeVehicle(vehicle);
        //assert
    }
    @Test
    public void VehicleByType(){
        List<Vehicle> tom = dealershipRepository.ByType("Sedan",1);
        assertEquals(3,tom.size());
    }
    @Test
    public void VehicleByColor(){
        List<Vehicle> tom = dealershipRepository.ByColor("lue",1);
        assertEquals(2,tom.size());
    }
    @Test
    public void VehicleByMileage(){
        List<Vehicle> tom = dealershipRepository.ByMileage(14000,23000,1);
        assertEquals(2,tom.size());
    }
    @Test
    public void VehicleByYear(){
        List<Vehicle> tom = dealershipRepository.ByYear(1990,2019,3);
        assertEquals(2,tom.size());
    }
    @Test
    public void VehicleByPriceRange(){
       List<Vehicle> tom = dealershipRepository.ByPriceRange(19001,44000,1);
       assertEquals(2,tom.size());
    }
    @Test
    public void VehicleByMakeModel(){
        List<Vehicle> tom = dealershipRepository.ByMakeModel("","",1);
        assertEquals(3,tom.size());
    }


}