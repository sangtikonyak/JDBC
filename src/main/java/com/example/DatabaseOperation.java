package com.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseOperation {
    //define method for getting connection
    //define method for getting table

    //connection
    public Connection getDbConnection()
    {
        Connection con=null;
        String url="jdbc:mysql://localhost:3306/salesdata";
        String user="root";
        String password="root@123";
        try {
            //register driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //get connection using driver manager
            con= DriverManager.getConnection(url,user,password);
        }
        catch(ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
        }
        return con;
    }

    //create table
    public boolean createTable()
    {
        boolean response=false;
        Connection connection=getDbConnection();

        try {
            Statement statement = connection.createStatement();
            String sql="create table if not exists salesperson(sales_id int, salesperson_name varchar(150),salesperson_city varchar(150), sales_commission float )";
            //execute sql
            response=statement.execute(sql);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return response;
    }

    // insert data

    public  int insertDataIntoTable(int id,String name,String city,float rate)
    {
        //connection
        //statement
        // use execute method
        int response=0;
        Connection connection=getDbConnection();
        try{
            Statement statement=connection.createStatement();
            String sql="INSERT INTO SALESPERSON VALUES("+ id + ",'"+ name +"','" + city +"'," + rate + ")";
            response=statement.executeUpdate(sql);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return response;
    }

    // getting data from database
    public List<SalesPerson> getAllSalesPerson()
    {
        List<SalesPerson> list= new ArrayList<>();
        Connection com=getDbConnection();
        try{
            Statement statement=com.createStatement();
            String sql="SELECT * FROM SALESPERSON";
            ResultSet resultSet=statement.executeQuery(sql);
            //process result set by iterating
            while (resultSet.next())
            {
                int id=resultSet.getInt(1);
                String name=resultSet.getString(2);
                String city=resultSet.getString(3);
                float rate=resultSet.getFloat(4);

                SalesPerson salesPerson=new SalesPerson(id,name,city,rate);
                list.add(salesPerson);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return list;
    }
}
