package com.bootcoding.jdbc_connectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class User_table{
    public static void main(String[] args) {
        try{

            //1. Load jdbc driver
            Class.forName("org.postgresql.Driver");

            //2. get database connection object..
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "5803");

            //3. Query database using statement object..
            Statement stmt = conn.createStatement();

            //4. execute query and get ResultSet
            ResultSet rs = stmt.executeQuery("select * from user_table");
            //4.1 Extract Result..
            while(rs.next()){

                // single row
                int userId = rs.getInt("id");
                String name = rs.getString("name");
                String mail = rs.getString("email");
                String address = rs.getString("address");


                System.out.println("Id = " + userId);
                System.out.println("Name = " + name);
                System.out.println("Mail = " + mail);
                System.out.println("Address = " + address);


            }

            //5. Connection Close;
            conn.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
