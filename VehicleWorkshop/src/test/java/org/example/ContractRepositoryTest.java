package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContractRepositoryTest {
    @Test
    public void SalesTest(){
        //arrange
        Vehicle vehicle = new Vehicle("555444",1995,"Explorer","Ford","SUV","Red",20000,19000);
        SalesContract contract = new SalesContract("date","jake","email",vehicle,false);
        ContractRepository contractRepository = new ContractRepository("jdbc:mysql://localhost:3306/dealership","root","YUm15510n");
        //act//assert
        contractRepository.addSalesContract(contract);
    }

    @Test
    public void LeaseTest(){
        //arrange
        Vehicle vehicle = new Vehicle("555444",1995,"Explorer","Ford","SUV","Red",20000,19000);
        LeaseContract contract = new LeaseContract("date","jake","email",vehicle);
        ContractRepository contractRepository = new ContractRepository("jdbc:mysql://localhost:3306/dealership","root","YUm15510n");
        //act//assert
        contractRepository.addLeaseContract(contract);

    }

}