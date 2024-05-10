package org.example;

import java.util.*;

public class UI {
    public static String userInput(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static void dealershipSelect(){

        while (true) {
            System.out.println("dealership options");

            switch (userInput().toLowerCase()){
//                case "a" -> DealershipFileManager.filePath = "path1";
//                case "b" -> DealershipFileManager.filePath = "path2";
//                case "c" -> DealershipFileManager.filePath = "path3";
                case "x" -> System.exit(0);
                default -> System.out.println("reselect prompt");
            }

        }
    }

    public static void homeScreen(){
        while (true){
            System.out.println("home screen prompt");

            switch (userInput().toLowerCase()){
                case"1"-> processGetByPriceRequest();
                case"2"-> processGetByMakeModelRequest();
                case"3"-> processGetByYearRequest();
                case"4"-> processGetByColorRequest();
                case"5"-> processGetByMileageRequest();
                case"6"-> processGetByVehicleTypeRequest();
                case"7"-> processAllVehicleRequest();
                case"8"-> processAddVehicleRequest();
                case"9"-> processRemoveVehicleRequest();
                case"0"-> dealershipSelect();
                case"x"-> System.exit(0);
                default-> System.out.println("reselect prompt");
            }
        }
    }

    private static void processGetByPriceRequest(){}
    private static void processGetByMakeModelRequest(){}
    private static void processGetByYearRequest(){}
    private static void processGetByColorRequest(){}
    private static void processGetByMileageRequest(){}
    private static void processGetByVehicleTypeRequest(){}
    private static void processAllVehicleRequest(){}
    private static void processAddVehicleRequest(){}
    private static void processRemoveVehicleRequest(){}


}
