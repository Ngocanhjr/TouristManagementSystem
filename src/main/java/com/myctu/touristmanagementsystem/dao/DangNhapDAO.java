/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myctu.touristmanagementsystem.dao;

import com.myctu.touristmanagementsystem.database.DatabaseUtils;
import com.myctu.touristmanagementsystem.model.DangNhap;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class DangNhapDAO {
//Kiểm tra tồn tại

    public DangNhapDAO() {
    }

    public boolean isExistKhachDuLich(String tenDangNhap) {
        Connection conn = DatabaseUtils.getConnection();
        String sql = "SELECT * FROM KHACH_DU_LICH WHERE TenDangNhap = ?";
        try {
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, tenDangNhap);
            ResultSet rs = stm.executeQuery();
            return rs.next(); // Nếu tìm thấy username thì tài khoản tồn tại
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean isExistChuDichVu(String tenDangNhap) {
        Connection conn = DatabaseUtils.getConnection();
        String sql = "SELECT * FROM CHU_DICH_VU WHERE TenDangNhap = ?";

        PreparedStatement stm;
        try {
            stm = conn.prepareStatement(sql);
            stm.setString(1, tenDangNhap);
            ResultSet rs = stm.executeQuery();
            return rs.next(); // Nếu tìm thấy username thì tài khoản tồn tại

        } catch (SQLException ex) {
            Logger.getLogger(DangNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }
// Kiểm tra đăng nhập thành công ?

    public boolean validateKhachDuLichLogin(String tenDangNhap, String matKhau) {
        DangNhap validDangNhap = new DangNhap();
        validDangNhap = null;
        Connection conn = DatabaseUtils.getConnection();
        String sql = "SELECT * FROM KHACH_DU_LICH WHERE TenDangNhap = ? AND MatKhau = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, tenDangNhap);
            stmt.setString(2, matKhau);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) { // Kiểm tra nếu có kết quả trả về từ DB
                String ten = rs.getString("TenDangNhap");
                String makhau = rs.getString("MatKhau");
                String role = rs.getString("VaiTro");
                validDangNhap = new DangNhap(tenDangNhap, matKhau, role);
                return true;  // Đăng nhập thành công
            }
//            System.out.println("valid kdl " + validDangNhap.getMatKhau());

        } catch (SQLException ex) {
            Logger.getLogger(DangNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
//        return validDangNhap;
        return false;
    }

    public boolean validateChuDichVuLogin(String tenDangNhap, String matKhau) {
        DangNhap validDangNhap = new DangNhap();
        validDangNhap = null;
        Connection conn = DatabaseUtils.getConnection();
        String sql = "SELECT * FROM CHU_DICH_VU WHERE TenDangNhap = ? AND MatKhau = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, tenDangNhap);
            stmt.setString(2, matKhau);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) { // Kiểm tra nếu có kết quả trả về từ DB
                String ten = rs.getString("TenDangNhap");
                String makhau = rs.getString("MatKhau");
                String role = rs.getString("VaiTro");
                validDangNhap = new DangNhap(tenDangNhap, matKhau, role);
                return true;  // Đăng nhập thành công
            }
//            System.out.println("valid cdv " + validDangNhap.getMatKhau());

        } catch (SQLException ex) {
            Logger.getLogger(DangNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

//        return validDangNhap;
        return false;
    }

}
