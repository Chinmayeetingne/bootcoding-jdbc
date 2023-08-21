package com.bootcoding.jdbc_connectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class InsertJdbcExample {
    public static void main(String[] args) {

        try{
            // 1. Load JDBC Driver
            Class.forName("org.postgresql.Driver");

            // 2. Get Database Connection Object
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "5803");

            // 3. Query Database using Statement Object
            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO customer VALUES(2000, 'Raju', 'Nagpur', 'raju@nagpur.com', 123)";
            // 4. Execute Query and Get ResultSet
            int i = stmt.executeUpdate(sql);
            // 4.1 Extract Result


            // 5.Connection CLose;
            conn.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
