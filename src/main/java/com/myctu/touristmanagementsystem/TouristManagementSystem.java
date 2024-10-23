/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.myctu.touristmanagementsystem;

import com.myctu.touristmanagementsystem.database.DatabaseUtils;
import com.myctu.touristmanagementsystem.model.ChuDichVu;
import com.myctu.touristmanagementsystem.dao.ChuDichVuDAO;

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
        if (success) {
            System.out.println("Done test db!");
        }

        // AdminView ad = new AdminView();
        // ad.setVisible(true);
        System.out.println("test ChuDichVuDAO");
        ChuDichVuDAO chudichvu = new ChuDichVuDAO();
        ChuDichVu cdv = new ChuDichVu();

        cdv.setHoVaTen("Nguyen Van B");
        cdv.setTenDangNhap("nguyenvana");
        cdv.setMatKhau("123456");
        cdv.setEmail("ale23@gmail.com");
        cdv.setSoDienThoai("0123456780");

        chudichvu.update(cdv);

        

    }
}
