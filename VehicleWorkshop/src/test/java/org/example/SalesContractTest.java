package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SalesContractTest {

    @Test
    void getTotalPrice() {
        //arrange
        Vehicle car = new Vehicle(1,1997,"","","","",0,2000);
        SalesContract x = new SalesContract("now","kirk","Email",car,true);
        //act
        double value = x.getTotalPrice();
        //assert
        assertEquals(2695,value);
    }

    @Test
    void getMonthlyPayment() {
        //arrange
        Vehicle car = new Vehicle(1,1997,"","","","",0,10000);
        SalesContract x = new SalesContract("now","kirk","Email",car,true);
        //act
        System.out.println(x);
        //assert
        assertEquals(226.91,x.monthlyPayment);
    }
}