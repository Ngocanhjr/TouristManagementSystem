/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myctu.touristmanagementsystem.dao;

import com.myctu.touristmanagementsystem.database.DatabaseUtils;
import com.myctu.touristmanagementsystem.model.KhachDuLich;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class KhachDuLichDAO implements DAOInterface<KhachDuLich> {

    @Override
    public boolean insert(KhachDuLich khachDuLich) {
        Connection conn = DatabaseUtils.getConnection();
        String sqlInsert = "insert into KHACH_DU_LICH (TenKDL, TenDangNhap, MatKhau, Email, SoDienThoai,VaiTro) values (?,?,?,?,?,?)";

        try {
            PreparedStatement stm = conn.prepareStatement(sqlInsert);

            stm.setNString(1, khachDuLich.getHoVaTen());
            stm.setString(2, khachDuLich.getTenDangNhap());
            stm.setString(3, khachDuLich.getMatKhau());
            stm.setString(4, khachDuLich.getEmail());
            stm.setString(5, khachDuLich.getSoDienThoai());
            stm.setString(6, khachDuLich.getVaiTro());
            stm.executeUpdate();

            stm.close();
            System.out.println("Insert");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(KhachDuLichDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(KhachDuLichDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    @Override
    public boolean update(KhachDuLich khachDuLich) {
        Connection conn = DatabaseUtils.getConnection();
        String sqlUpDate = "update KHACH_DU_LICH set TenKDL = ?, Email = ?, SoDienThoai = ? where TenDangNhap = ? ";

        try {
            PreparedStatement stm = conn.prepareStatement(sqlUpDate);

            stm.setString(1, khachDuLich.getHoVaTen());
            stm.setString(2, khachDuLich.getEmail());
            stm.setString(3, khachDuLich.getSoDienThoai());
            stm.setString(4, khachDuLich.getTenDangNhap());

            stm.executeUpdate();

            System.out.println("update kdl");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(KhachDuLichDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(KhachDuLichDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return false;
    }

    @Override
    public boolean delete(KhachDuLich khachDuLich) {
        Connection conn = DatabaseUtils.getConnection();
        String sqlDelete = "delete from KHACH_DU_LICH where TenDangNhap = ?";

        try {
            PreparedStatement stm = conn.prepareStatement(sqlDelete);

            stm.setString(1, khachDuLich.getTenDangNhap());

            stm.executeUpdate();
            System.out.println("Delete kdl");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(KhachDuLichDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(KhachDuLichDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    @Override
    public List<KhachDuLich> selectAll() {
        List<KhachDuLich> khachDuLichs = new ArrayList<>();
        Connection conn = DatabaseUtils.getConnection();
        String sqlSelect = "select * from KHACH_DU_LICH";

        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sqlSelect);

            while (rs.next()) {
                String ten = rs.getString("TenKDL");
                String tenDangNhap = rs.getString("TenDangNhap");
                String mk = rs.getString("MatKhau");
                String em = rs.getString("Email");
                String sdt = rs.getString("SoDienThoai");

                KhachDuLich kdl = new KhachDuLich(ten, tenDangNhap, mk, em, sdt);
                khachDuLichs.add(kdl);
            }
            System.out.println("select all");

        } catch (SQLException ex) {
            Logger.getLogger(KhachDuLichDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(KhachDuLichDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return khachDuLichs;
    }

    @Override
    public KhachDuLich selectByTenDangNhap(KhachDuLich khachDuLich) {
        Connection conn = DatabaseUtils.getConnection();
        String sql = "select * from KHACH_DU_LICH where TenDangNhap = ?";
        KhachDuLich kdl = new KhachDuLich();
        try {
            PreparedStatement stm = conn.prepareStatement(sql);   
            stm.setString(1, khachDuLich.getTenDangNhap());
            
            ResultSet rs = stm.executeQuery();
            
            while(rs.next()){
                String ten = rs.getString("TenKDL");
                String tenDangNhap = rs.getString("TenDangNhap");
                String matKhau = rs.getString("MatKhau");
                String email = rs.getString("Email");
                String sdt = rs.getString("SoDienThoai");
                kdl.setHoVaTen(ten);
                kdl.setTenDangNhap(tenDangNhap);
                kdl.setMatKhau(matKhau);
                kdl.setEmail(email);
                kdl.setSoDienThoai(sdt);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(KhachDuLichDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(KhachDuLichDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return kdl;
    }

    public String getVaiTro(String tenDangNhap) {
        Connection conn = DatabaseUtils.getConnection();
        String selectRole = "select VaiTro from KHACH_DU_LICH where TenDangNhap = '" + tenDangNhap + "'";
        String role = null;
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(selectRole);
            while (rs.next()) {
               role = rs.getString("VaiTro");
            }
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(KhachDuLichDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(KhachDuLichDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
//        System.out.println(role);
        return role;
    }
}
