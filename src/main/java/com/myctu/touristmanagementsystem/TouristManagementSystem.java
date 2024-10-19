/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.myctu.touristmanagementsystem;

import com.myctu.touristmanagementsystem.database.DatabaseUtils;
import java.sql.Connection;

/**
 *
 * @author ASUS
 */
public class TouristManagementSystem {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Connection con = DatabaseUtils.getConnection();
        boolean success = DatabaseUtils.checkConnection(con);
        if(success){
            System.out.println("Done test db!");
        }
        
//       AdminView ad = new AdminView();
//       ad.setVisible(true);
    }
}
