package org.example;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;
class LeaseContractTest {


    @Test
    void getTotalPrice() {
        //arrange
        Vehicle car = new Vehicle(1,1997,"","","","",0,2000);
        LeaseContract x = new LeaseContract("now","kirk","Email",car);
        //act
        double value = x.getTotalPrice();
        //assert
        assertEquals(2140,value);
    }

    @Test
    void getMonthlyPayment() {
        //arrange
        Vehicle car = new Vehicle(1,1997,"","","","",0,31995.00);
        LeaseContract x = new LeaseContract("now","kirk","Email",car);
        //act
        //assert
        assertEquals(507.39,x.monthlyPayment);

    }
    @Test
    void getCorrectDate() {
        //arrange
        //act
        String x =(LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE)).toString().replaceAll("-","");
        //assert
        assertEquals("20240519",x);

    }
}