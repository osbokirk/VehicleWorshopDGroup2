package org.example;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.LocalDate;
import java.util.Map;
import static java.math.RoundingMode.CEILING;
import static java.math.RoundingMode.FLOOR;

public class SalesContract extends Contract {
    private final double taxRate=.05;
    private double salesTaxAmmount;
    private double recordingFee = 100;
    private final double[] processingFeeArray = {295,495};
    private double processingFee;
    private boolean isFinanced;
    private final double[] intrestRates = {.0425,.0525};
    private final Map<Double,Integer> rateTermMap= Map.of(.0425,48,.0525,24);
    private double intrestRate;
    private int termLenght;

    public SalesContract(String date, String customerName, String email, Vehicle vehicleSold, boolean isFinanced) {
        super(date, customerName, email, vehicleSold);
        this.isFinanced = isFinanced;
        if(isFinanced = true){
            if(vehicleSold.getPrice() >= 10000){
               intrestRate = intrestRates[0];
               termLenght = rateTermMap.get(intrestRate);
               monthlyPayment =getMonthlyPayment();
            }else{
                intrestRate = intrestRates[1];
                termLenght = rateTermMap.get(intrestRate);
                monthlyPayment =getMonthlyPayment();
            }
        }
        if (vehicleSold.getPrice() >= 10000){
            processingFee = processingFeeArray[0];
        }else{
            processingFee = processingFeeArray[1];
        }
        salesTaxAmmount= taxRate* vehicleSold.getPrice();
        totalPrice = getTotalPrice();

    }

    @Override
    public double getTotalPrice() {
        double v = (double) vehicleSold.getPrice() + salesTaxAmmount + recordingFee + processingFee;
        return v;
    }

    @Override
    public double getMonthlyPayment() {
       /*
        BigDecimal v = BigDecimal.valueOf((vehicleSold.getPrice() * (intrestRate / 12)) /
        (1-(Math.pow((1+intrestRate/12),-termLenght))));
    return v.doubleValue();

        */
        MathContext mathContext = new MathContext(5,FLOOR) ;
        BigDecimal v = BigDecimal.valueOf((vehicleSold.getPrice()) * (intrestRate / 12) / (1 -   Math.pow  (1 + (intrestRate / 12) , (-termLenght)))).round(mathContext);
        return v.doubleValue();
    }

    @Override
    public String toString() {
        String x = String.format("""
            Sale|%s|%s|%s
            %s
            %,.2f|%,.2f|%,.2f|%,.2f|%s|%,.2f 
            """, date,customerName,email,vehicleSold.toString(),
                salesTaxAmmount,recordingFee,processingFee,totalPrice,isFinanced?"YES":"NO",monthlyPayment);
        return x;
    }//"SALE"|Date|CustomerName|CustomerEmail
    //vehicle tostring
    //sales tax|recording fee|processing fee|total|fiance|monthly payment
}
