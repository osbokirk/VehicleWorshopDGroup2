package org.example;

import java.util.*;

public class UI {

    private static Dealership sorting;
    public static String userInput(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

//    public static void dealershipSelect(){
//
//        while (true) {
//            System.out.println("dealership options");
//
//            switch (userInput().toLowerCase()){
//                case "a" -> DealershipFileManager.filePath = "path1";
//                case "b" -> DealershipFileManager.filePath = "path2";
//                case "c" -> DealershipFileManager.filePath = "path3";
//                case "x" -> System.exit(0);
//                default -> System.out.println("reselect prompt");
//            }
//
//        }
//    }

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
//                case"0"-> dealershipSelect();
                case"x"-> System.exit(0);
                default-> System.out.println("reselect prompt");
            }
        }
    }
    private static void processGetByPriceRequest(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("input price range prompt");
        System.out.println("highest price");
        String maxPriceInput = scanner.nextLine();

        System.out.println("lowest price");
        String minPriceInput = scanner.nextLine();

        Double maxPrice = 9999999.00;
        Double minPrice = 0.00;

        try {
            if (!maxPriceInput.isEmpty()){
                maxPrice = Double.parseDouble(maxPriceInput);
            }
        }
        catch (NumberFormatException ex){
            System.out.println("not a numerical input prompt");
        }

        try {
            if (!minPriceInput.isEmpty()){
                minPrice = Double.parseDouble(minPriceInput);
            }
        }
        catch (NumberFormatException ex){
            System.out.println("not a numerical input prompt");
        }

        System.out.println(sorting.getVehiclesByPrice(minPrice,maxPrice).toString());
    }
    private static void processGetByMakeModelRequest(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("input make");
        String make = scanner.nextLine();

        System.out.println("input model");
        String model = scanner.nextLine();

    }
    private static void processGetByYearRequest(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("input year range prompt");
        System.out.println("latest year");
        String maxYearInput = scanner.nextLine();

        System.out.println("earliest year");
        String minYearInput = scanner.nextLine();

        int maxYear = 3000;
        int minYear = 1900;

        try {
            if (!maxYearInput.isEmpty()){
                maxYear = Integer.parseInt(maxYearInput);
            }
        }
        catch (NumberFormatException ex){
            System.out.println("not a numerical input prompt");
        }

        try {
            if (!minYearInput.isEmpty()){
                minYear = Integer.parseInt(minYearInput);
            }
        }
        catch (NumberFormatException ex){
            System.out.println("not a numerical input prompt");
        }

        System.out.println(sorting.getVehiclesByPrice(minYear,maxYear).toString());
    }
    private static void processGetByColorRequest(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("input color");
        String color = scanner.nextLine();
    }
    private static void processGetByMileageRequest(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("input odometer mileage");
        int odometer = scanner.nextInt();
    }
    private static void processGetByVehicleTypeRequest(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("input vehicle type");
        String vehicleType = scanner.nextLine();
    }
    private static void processAllVehicleRequest(){
        Scanner scanner = new Scanner(System.in);
    }
    private static void processAddVehicleRequest(){
        Scanner scanner = new Scanner(System.in);

        while (true) {

            try {
                Vehicle addVehicle = new Vehicle();

                System.out.println("input vin");
                int vin = Integer.parseInt(scanner.nextLine());

                System.out.println("input year");
                int year = Integer.parseInt(scanner.nextLine());

                System.out.println("input model");
                String model = scanner.nextLine();

                System.out.println("input make");
                String make = scanner.nextLine();

                System.out.println("input color");
                String color = scanner.nextLine();

                System.out.println("input vehicle type");
                String vehicleType = scanner.nextLine();

                System.out.println("input odometer mileage");
                int odometer = Integer.parseInt(scanner.nextLine());

                System.out.println("input price");
                double price = Double.parseDouble(scanner.nextLine());
            }
            catch (NumberFormatException ex) {
                System.out.println("need numerical input");
            }
            homeScreen();
        }
    }
    private static void processRemoveVehicleRequest(){
        Scanner scanner = new Scanner(System.in);
    }


}
