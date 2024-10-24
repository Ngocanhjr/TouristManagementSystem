/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myctu.touristmanagementsystem.test;

import com.myctu.touristmanagementsystem.dao.KhachDuLichDAO;
import com.myctu.touristmanagementsystem.model.KhachDuLich;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class testKdLDAO {

    public static void main(String[] args) {
        System.out.println("Test KhachDuLichDAO");
        KhachDuLich kdl = new KhachDuLich();
        kdl.setHoVaTen("Nguyen Van B");
        kdl.setTenDangNhap("nguyenvanA");
        kdl.setMatKhau("nguyenvanb");
        kdl.setEmail("nguyevanb1999@gmail.com");
        kdl.setSoDienThoai("091278341");
        
        KhachDuLichDAO kdlDAO = new KhachDuLichDAO();
//        kdlDAO.insert(kdl);
//---------------Update
//        kdlDAO.update(kdl);
//                List<KhachDuLich> kdls = kdlDAO.selectAll();
//        for (KhachDuLich klddDuLich : kdls) {
//            System.out.println("Khacd du lich: " + klddDuLich.getHoVaTen());
//            System.out.println("Khacd du lich: " + klddDuLich.getTenDangNhap());
//            System.out.println("Khacd du lich: " + klddDuLich.getMatKhau());
//        }
        
        KhachDuLich find = new KhachDuLich();
        find.setTenDangNhap("nguyenvanA");
        find = kdlDAO.selectByTenDangNhap(find);
        System.out.println("Ten: " + find.getEmail());
    }
}
