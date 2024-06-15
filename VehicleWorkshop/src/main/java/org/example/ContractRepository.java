package org.example;


import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class ContractRepository {
    private BasicDataSource basicDataSource;
    public ContractRepository (String url,String userName,String password){
        basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(url);
        basicDataSource.setUsername(userName);
        basicDataSource.setPassword(password);
    }
    public void addLeaseContract(LeaseContract contract){
        String query = "{Call AddLeaseContract(?,?,?,?,?)}";
        try (Connection con = basicDataSource.getConnection(); CallableStatement callableStatement = con.prepareCall(query)){
            callableStatement.setString(1,contract.getVehicleSold().getVin());
            callableStatement.setFloat(2,(float) contract.endingValue);
            callableStatement.setFloat(3,(float) contract.leaseFeeCharge);
            callableStatement.setFloat(4,(float) contract.monthlyPayment);
            callableStatement.setFloat(5,(float) contract.totalPrice);
            callableStatement.executeQuery();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
    public void addSalesContract(SalesContract contract){
        String query = "{Call AddSalesContract(?,?,?,?,?,?,?,?)}";
        try (Connection con = basicDataSource.getConnection();CallableStatement call = con.prepareCall(query)){
            call.setString(1,contract.getVehicleSold().getVin());
            call.setFloat(2,(float) contract.getSalesTaxAmmount());
            call.setBoolean(3,contract.isFinanced());
            call.setInt(4, contract.getTermLenght());
            call.setFloat(5,(float) contract.getIntrestRate());
            call.setFloat(6,(float) contract.getProcessingFee());
            call.setFloat(7,(float)contract.getTotalPrice());
            call.setFloat(8,(float)contract.getMonthlyPayment());
            call.executeQuery();
        }catch (SQLException ex ){
            ex.printStackTrace();
        }
    }

}
