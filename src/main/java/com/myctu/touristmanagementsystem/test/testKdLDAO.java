/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myctu.touristmanagementsystem.test;

import com.myctu.touristmanagementsystem.dao.KhachDuLichDAO;
import com.myctu.touristmanagementsystem.model.KhachDuLich;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class testKdLDAO {
    
    public static void main(String[] args) {
        System.out.println("Test KhachDuLichDAO");
        KhachDuLich kdl = new KhachDuLich();
        kdl.setHoVaTen("Rhna");
        kdl.setTenDangNhap("rh");
        kdl.setMatKhau("123");
        kdl.setEmail("anhle1999@gmail.com");
        kdl.setSoDienThoai("0322378341");
        kdl.setVaiTro("khachdulich");
        
        KhachDuLichDAO kdlDAO = new KhachDuLichDAO();
//        kdlDAO.insert(kdl);
//---------------Update
//        kdlDAO.update(kdl);
//        kdlDAO.delete(kdl);
                List<KhachDuLich> kdls = kdlDAO.selectAll();
//        for (KhachDuLich klddDuLich : kdls) {
//            System.out.println("Khacd du lich: " + klddDuLich.getHoVaTen());
//            System.out.println("Khacd du lich: " + klddDuLich.getTenDangNhap());
//            System.out.println("Khacd du lich: " + klddDuLich.getMatKhau());
//        }
//        
        KhachDuLich find = new KhachDuLich();
        find.setTenDangNhap("rh");
        find = kdlDAO.selectByTenDangNhap(find);
        System.out.println("Ten: " + find.getEmail());
      String role = kdlDAO.getVaiTro("rh");
        System.out.println(role);
    }
}
