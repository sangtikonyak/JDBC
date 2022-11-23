package com.example;

import java.sql.Connection;
import java.util.List;

public class DatabaseImpl {
    public static void main(String[] args) {
        DatabaseOperation databaseOperation=new DatabaseOperation();
        Connection connection= databaseOperation.getDbConnection();
        if(connection !=null)
        {
            System.out.println("connection established");
        }
        else {
            System.out.println("connection failed");
        }
        boolean result=databaseOperation.createTable();
        if(!result)
        {
            System.out.println("table created");
        }
        else {
            System.out.println("table not created");
        }

        int rowAffected=databaseOperation.insertDataIntoTable(1,"abc","mon",30.1f);
        if(rowAffected==1)
        {
            System.out.println("data inserted");
        }
        else {
            System.out.println("data not inserted");
        }

        List<SalesPerson> allSalesPerson = databaseOperation.getAllSalesPerson();

        System.out.println("allSalesPerson = " + allSalesPerson);
    }
}
