package com.bootcoding.jdbc_connectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectJdbcExample {
    public static void main(String[] args) {

        try{
            // 1. Load JDBC Driver
            Class.forName("org.postgresql.Driver");

            // 2. Get Database Connection Object
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "5803");

            // 3. Query Database using Statement Object
            Statement stmt = conn.createStatement();

            // 4. Execute Query and Get ResultSet
            ResultSet rs = stmt.executeQuery("SELECT * FROM customer where city= ");
            // 4.1 Extract Result

            while(rs.next()){

                // Single Row
                int custId = rs.getInt("customer_id");
                int custId2 = rs.getInt(1);
                String name = rs.getString("cust_name");
                String city = rs.getString("city");
                String email = rs.getString("email");
                int salesManId = rs.getInt("salesman_id");

                System.out.println("Id = " + custId);
                System.out.println("Name = " + name);
                System.out.println("City = " + city);
                System.out.println("Email = " + email);
                System.out.println("SalesMan Id = " + salesManId);
            }

            // 5.Connection CLose;
            conn.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
