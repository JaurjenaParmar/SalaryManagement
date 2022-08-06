/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.salarymanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionClass {

    private static ConnectionClass single_instance = null;
    Connection connection;

    private ConnectionClass() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/salarymanagement", "root", "");
            if (connection != null) {
                System.out.println("connected");
//                String query="DROP TABLE MANAGE_SALARY";
//                PreparedStatement ps=connection.prepareStatement(query);
//                ps.execute();
                String query1 = "CREATE TABLE IF NOT EXISTS users ( ID INT NOT NULL AUTO_INCREMENT , "
                        + "name VARCHAR(255), "
                        + "role VARCHAR(255),"
                        + "joiningDate VARCHAR(255), "
                        + "Age INT,"
                        + "Address VARCHAR(255) , "
                        + "contact VARCHAR(255 ) , "
                        + "email VARCHAR(255), "
                        + "password VARCHAR(255), "
                        + "PRIMARY KEY(ID))";
                PreparedStatement ps1 = connection.prepareStatement(query1);
                ps1.execute();
                System.out.println("Table users created successfully");

                String query2="CREATE TABLE IF NOT EXISTS MANAGE_SALARY (ID INT NOT NULL AUTO_INCREMENT, "
                        + "ManagerID INT , "
                        + "consultantName VARCHAR(255), "
                        + "consultantID INT , "
                        + "Date VARCHAR(255), "
                        + "SalaryShare DOUBLE, "
                        + "PRIMARY KEY(ID))";
                PreparedStatement ps2 = connection.prepareStatement(query2);
                ps2.execute();
                System.out.println("Table MANAGE_SALARY created successfully");

            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ConnectionClass getInstance() {
        if (single_instance == null) {
            single_instance = new ConnectionClass();
        }
        return single_instance;
    }
}

