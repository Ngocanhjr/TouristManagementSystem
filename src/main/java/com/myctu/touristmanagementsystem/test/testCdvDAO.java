/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.myctu.touristmanagementsystem.test;

import com.myctu.touristmanagementsystem.database.DatabaseUtils;
import com.myctu.touristmanagementsystem.model.ChuDichVu;
import com.myctu.touristmanagementsystem.dao.ChuDichVuDAO;

import java.sql.Connection;

/**
 *
 * @author ASUS
 */
public class testCdvDAO {

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
        //
         cdv.setHoVaTen("Anh le");
         cdv.setTenDangNhap("rhna");
         cdv.setMatKhau("123456");
         cdv.setEmail("ale23@gmail.com");
         cdv.setSoDienThoai("0123456780");
         cdv.setVaiTro("chudichvu");
         chudichvu.insert(cdv);
//        List<ChuDichVu> chudichvus = chudichvu.selectAll();
//        ChuDichVu find = new ChuDichVu();
//        find.setTenDangNhap("nguyenvana");
//        find = chudichvu.selectByTenDangNhap(find);
//        System.out.println("Ten: " + find.getHoVaTen());
//        
//        chudichvu.delete(cdv);
        // for (ChuDichVu chudichvu1 : chudichvus) {
        // System.out.println(chudichvu1);
        // }
        String role = chudichvu.getVaiTro("rhna");
        System.out.println(role);
    }
}
