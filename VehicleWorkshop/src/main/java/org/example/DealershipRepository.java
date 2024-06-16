package org.example;

import com.sun.jdi.ByteType;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DealershipRepository {
    private BasicDataSource basicDataSource;
    public  DealershipRepository (String url,String userName,String password){
        basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(url);
        basicDataSource.setUsername(userName);
        basicDataSource.setPassword(password);
    }
    public void addVehicle(Vehicle car,int dealershipId){
        String query ="{Call AddVehicle(?,?,?,?,?,?,?,?,?,?)}";
        try (Connection connection = basicDataSource.getConnection();CallableStatement callableStatement = connection.prepareCall(query)){
            callableStatement.setString(1,( car.getVin()).toString());
            callableStatement.setInt(2,car.getYear());
            callableStatement.setString(3,car.getModel());
            callableStatement.setString(4,car.getMake());
            callableStatement.setString(5,car.getVehicleType());
            callableStatement.setString(6,car.getColor());
            callableStatement.setInt(7,car.getOdometer());
            callableStatement.setFloat(8,(float)car.getPrice());
            callableStatement.setBoolean(9,false);
            callableStatement.setInt(10,dealershipId);
            callableStatement.executeQuery();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
    public void removeVehicle(Vehicle car){
        String vinToRemove = (car.getVin()).toString();
        String query = "{Call RemoveVehicle(?)}";
        try(Connection connection = basicDataSource.getConnection(); CallableStatement callableStatement = connection.prepareCall(query)){
           callableStatement.setString(1,vinToRemove);
           callableStatement.executeQuery();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
    public List<Vehicle> ByPriceRange(double minVal, double maxVal, int dealershipId){
        String preparedStatement ="{Call VehicleByPrice(?,?,?)}";
        List<Vehicle> vehicleList = new ArrayList<>();
        try (Connection connection = basicDataSource.getConnection();CallableStatement query = connection.prepareCall(preparedStatement)){
            query.setDouble(1,minVal);
            query.setDouble(2,maxVal);
            query.setInt(3,dealershipId);
            ResultSet resultSet = query.executeQuery();
            while (resultSet.next()){
                String vin = resultSet.getString("Vin");
                int modelYear= resultSet.getInt("ModelYear");
                String model = resultSet.getString("Model");
                String make = resultSet.getString("Make");
                String vehicleType = resultSet.getString("VehicleType");
                String color = resultSet.getString("Color");
                int odometer = resultSet.getInt("Odometer");
                double price = resultSet.getFloat("Price");
                Vehicle vehicle =  new Vehicle(vin,modelYear,make,model,vehicleType,color,odometer,price);
                vehicleList.add(vehicle);
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return vehicleList;
    }
    public List<Vehicle> ByMakeModel(String make, String model, int dealershipId){
        String preparedStatement ="{Call VehicleByMakeModel(?,?,?)}";
        List<Vehicle> vehicleList = new ArrayList<>();
        try (Connection connection = basicDataSource.getConnection();CallableStatement query = connection.prepareCall(preparedStatement)){
            query.setString(1,make);
            query.setString(2,model);
            query.setInt(3,dealershipId);
            ResultSet resultSet = query.executeQuery();
            while (resultSet.next()){
                String vin = resultSet.getString("Vin");
                int modelYear= resultSet.getInt("ModelYear");
                String vehicleModel = resultSet.getString("Model");
                String vehicleMake = resultSet.getString("Make");
                String vehicleType = resultSet.getString("VehicleType");
                String color = resultSet.getString("Color");
                int odometer = resultSet.getInt("Odometer");
                double price = resultSet.getFloat("Price");
                Vehicle vehicle =  new Vehicle(vin,modelYear,vehicleMake,vehicleModel,vehicleType,color,odometer,price);
                vehicleList.add(vehicle);
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return vehicleList;
    }
    public List<Vehicle> ByYear(int minVal, int maxVal, int dealershipId){
        String preparedStatement ="{Call VehicleByYear(?,?,?)}";
        List<Vehicle> vehicleList = new ArrayList<>();
        try (Connection connection = basicDataSource.getConnection();CallableStatement query = connection.prepareCall(preparedStatement)){
            query.setInt(1,minVal);
            query.setInt(2,maxVal);
            query.setInt(3,dealershipId);
            ResultSet resultSet = query.executeQuery();
            while (resultSet.next()){
                String vin = resultSet.getString("Vin");
                int modelYear= resultSet.getInt("ModelYear");
                String model = resultSet.getString("Model");
                String make = resultSet.getString("Make");
                String vehicleType = resultSet.getString("VehicleType");
                String color = resultSet.getString("Color");
                int odometer = resultSet.getInt("Odometer");
                double price = resultSet.getFloat("Price");
                Vehicle vehicle =  new Vehicle(vin,modelYear,make,model,vehicleType,color,odometer,price);
                vehicleList.add(vehicle);
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return vehicleList;
    }
    public List<Vehicle> ByMileage(int minVal, int maxVal, int dealershipId){
        String preparedStatement ="{Call VehiclesByOdometer(?,?,?)}";
        List<Vehicle> vehicleList = new ArrayList<>();
        try (Connection connection = basicDataSource.getConnection();CallableStatement query = connection.prepareCall(preparedStatement)){
            query.setInt(1,minVal);
            query.setInt(2,maxVal);
            query.setInt(3,dealershipId);
            ResultSet resultSet = query.executeQuery();
            while (resultSet.next()){
                String vin = resultSet.getString("Vin");
                int modelYear= resultSet.getInt("ModelYear");
                String model = resultSet.getString("Model");
                String make = resultSet.getString("Make");
                String vehicleType = resultSet.getString("VehicleType");
                String color = resultSet.getString("Color");
                int odometer = resultSet.getInt("Odometer");
                double price = resultSet.getFloat("Price");
                Vehicle vehicle =  new Vehicle(vin,modelYear,make,model,vehicleType,color,odometer,price);
                vehicleList.add(vehicle);
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return vehicleList;
    }
    public List<Vehicle> ByColor(String color, int dealershipId){
        String preparedStatement ="{Call VehicleByColor(?,?)}";
        List<Vehicle> vehicleList = new ArrayList<>();
        try (Connection connection = basicDataSource.getConnection();CallableStatement query = connection.prepareCall(preparedStatement)){
            query.setString(1,color);
            query.setInt(2,dealershipId);
            ResultSet resultSet = query.executeQuery();
            while (resultSet.next()){
                String vin = resultSet.getString("Vin");
                int modelYear= resultSet.getInt("ModelYear");
                String model = resultSet.getString("Model");
                String make = resultSet.getString("Make");
                String vehicleType = resultSet.getString("VehicleType");
                String vehicleColor = resultSet.getString("Color");
                int odometer = resultSet.getInt("Odometer");
                double price = resultSet.getFloat("Price");
                Vehicle vehicle =  new Vehicle(vin,modelYear,make,model,vehicleType,vehicleColor,odometer,price);
                vehicleList.add(vehicle);
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return vehicleList;
    }

    public List<Vehicle> ByType(String type, int dealershipId){
        String preparedStatement ="{Call VehicleByType(?,?)}";
        List<Vehicle> vehicleList = new ArrayList<>();
        try (Connection connection = basicDataSource.getConnection();CallableStatement query = connection.prepareCall(preparedStatement)){
            query.setString(1,type);
            query.setInt(2,dealershipId);
            ResultSet resultSet = query.executeQuery();
            while (resultSet.next()){
                String vin = resultSet.getString("Vin");
                int modelYear= resultSet.getInt("ModelYear");
                String model = resultSet.getString("Model");
                String make = resultSet.getString("Make");
                String vehicleType = resultSet.getString("VehicleType");
                String color = resultSet.getString("Color");
                int odometer = resultSet.getInt("Odometer");
                double price = resultSet.getFloat("Price");
                Vehicle vehicle =  new Vehicle(vin,modelYear,make,model,vehicleType,color,odometer,price);
                vehicleList.add(vehicle);
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return vehicleList;
    }
    public List<Vehicle> GetAll(int DealershipId){
        String preparedStatement = "{Call GetAllVehicles(?,?)}";
        List<Vehicle> vehicleList = new ArrayList<>();
        try (Connection connection = basicDataSource.getConnection();CallableStatement query = connection.prepareCall(preparedStatement)){
            query.setInt(1,DealershipId);
            ResultSet resultSet = query.executeQuery();
        while (resultSet.next()){
            String vin = resultSet.getString("Vin");
            int modelYear= resultSet.getInt("ModelYear");
            String model = resultSet.getString("Model");
            String make = resultSet.getString("Make");
            String vehicleType = resultSet.getString("VehicleType");
            String color = resultSet.getString("Color");
            int odometer = resultSet.getInt("Odometer");
            double price = resultSet.getFloat("Price");
            Vehicle vehicle =  new Vehicle(vin,modelYear,make,model,vehicleType,color,odometer,price);
            vehicleList.add(vehicle);
        }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return vehicleList;
    }
}
