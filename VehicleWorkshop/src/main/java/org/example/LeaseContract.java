package org.example;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;

import static java.math.RoundingMode.CEILING;
import static java.math.RoundingMode.FLOOR;

public class LeaseContract extends Contract {
    //private static final DecimalFormat decfor = new DecimalFormat("0.00");
    public final double deprecationAmmount = .50;
    public double endingValue;//50% of starting Value

    public final double leaseFee = .07;
    public double leaseFeeCharge;//7% of the orginalPrice

    public final double intrestRate = .04;//4%
    public final double termLenght = 36;//36 months

    public LeaseContract(String date, String customerName, String email, Vehicle vehicleSold) {
        super(date, customerName, email, vehicleSold);
        this.endingValue = vehicleSold.getPrice() * deprecationAmmount;
        this.leaseFeeCharge = vehicleSold.getPrice() * leaseFee;
        this.monthlyPayment = getMonthlyPayment();
        this.totalPrice = getTotalPrice();
    }

    @Override
    public double getTotalPrice() {
       return vehicleSold.getPrice() + leaseFeeCharge;
    }

    @Override//p(r/12)  / [1-(1+r/n)^nt
    public double getMonthlyPayment() {
        double depreciationFee = ((vehicleSold.getPrice()-endingValue)/termLenght);
        System.out.println(depreciationFee);
        double financingFee =(vehicleSold.getPrice() + endingValue)*intrestRate/2400;
        System.out.println(financingFee);
        double monthlyLeaseFee = leaseFeeCharge/termLenght;
        System.out.println(monthlyLeaseFee);

        MathContext mathContext = new MathContext(5,CEILING) ;
        BigDecimal v =  BigDecimal.valueOf(depreciationFee + financingFee + monthlyLeaseFee).round(mathContext);

        return v.doubleValue();//Math.round(v*100)/100;
    }

    @Override
    public String toString(){
        String
        x = String.format("""
            LEASE|%s|%s|%s
            %s
            %,.2f|%f,.2f |%f,.2f|%f,.2f 
            """,date,customerName,email,vehicleSold.toString(),
                endingValue,leaseFeeCharge,totalPrice,monthlyPayment);
        ;
        //"LEASE"|Date|CustomerName|CustomerEmail
        //vehicle tostring
        //EndingValue|LeaseFee|Total|Monthly
        return x;
    }
}
