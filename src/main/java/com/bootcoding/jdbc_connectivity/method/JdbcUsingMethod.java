package com.bootcoding.jdbc_connectivity.method;


import com.bootcoding.jdbc_connectivity.utils.DBConnectionUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcUsingMethod {
    public static void main(String[] args) {
        JdbcUsingMethod jdbcUsingMethod = new JdbcUsingMethod();
        jdbcUsingMethod.getAllCustomers();
        jdbcUsingMethod.getTotalCustomerCount();
        jdbcUsingMethod.getTotalCustomerCountFromSpecificCity();
    }
    public List<Customer> getAllCustomers(){
        try{

            Connection connection = DBConnectionUtils.getConnection();
            Statement statement = connection.createStatement();
            String query  =  "SELECT * FROM CUSTOMER";
            ResultSet rs = statement.executeQuery(query);

            // Extract
            List<Customer> customers = new ArrayList<>();
            while(rs.next()){
                // Single Row
                int custId = rs.getInt("customer_id");
                int custId2 = rs.getInt(1);
                String name = rs.getString("cust_name");
                String city = rs.getString("city");
                String email = rs.getString("email");
                int salesManId = rs.getInt("salesman_id");

                Customer customer = new Customer();
                customer.setCustomerId(custId);
                customer.setSalesmanId(salesManId);
                customer.setName(name);
                customer.setCity(city);
                customer.setEmail(email);

                customers.add(customer);
            }
            return customers;

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    public int getTotalCustomerCount(){
        try{

            Connection connection = DBConnectionUtils.getConnection();
            Statement statement = connection.createStatement();
            String query  =  "SELECT count(*) FROM CUSTOMER";
            ResultSet rs = statement.executeQuery(query);

            if(rs.next()){
                int count = rs.getInt("count");
                System.out.println("Total Records in CUSTOMER is " + count);
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return 0;
    }

    public int getTotalCustomerCountFromSpecificCity(){
        try{

            Connection connection = DBConnectionUtils.getConnection();
            Statement statement = connection.createStatement();
            String query  =  "SELECT count(*) FROM CUSTOMER where city = 'Melaka'";
            ResultSet rs = statement.executeQuery(query);

            if(rs.next()){
                int count = rs.getInt("count");
                return count;
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return 0;
    }


    // Get all customers

    // Tell me how many customers we have
    // Tell me how many customer belongs to specific city we have
    // SELECT COUNT(*) from customer where city = 'specific';

    // Get all customers who belong to specific CITY

    // Get all customers which handled by specific salesman

    // Get a Customer by customer Id

    // Business Logic + JDBC Code
}
