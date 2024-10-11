/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myctu.touristmanagementsystem.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class DatabaseUtils {

    private static final String url = "jdbc:sqlserver://localhost:1433;databaseName=TouristManagementSystem;user=sa;password=12345678;"
            + "encrypt=true;trustServerCertificate=true;";

    public static Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection(url);
            System.out.println("Db successfull!");
            return conn;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static boolean checkConnection(Connection con) {
        if (con == null) {
            System.out.println("Db connect fail!");
            return false;
        }
        return true;
    }
}
