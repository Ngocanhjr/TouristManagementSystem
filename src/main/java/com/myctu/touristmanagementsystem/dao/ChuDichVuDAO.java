/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myctu.touristmanagementsystem.dao;

import com.myctu.touristmanagementsystem.database.DatabaseUtils;
import com.myctu.touristmanagementsystem.model.ChuDichVu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class ChuDichVuDAO implements DAOInterface<ChuDichVu> {

    public ChuDichVuDAO() {
    }

    @Override
    public boolean insert(ChuDichVu chuDichVu) {
        Connection conn = DatabaseUtils.getConnection();
        String sqlInsert = "Insert into CHU_DICH_VU (TenCDV, TenDangNhap, MatKhau, Email, SoDienThoai) values(?,?,?,?,?)";

        try {
            PreparedStatement stm = conn.prepareStatement(sqlInsert);

            stm.setString(1, chuDichVu.getHoVaTen());
            stm.setString(2, chuDichVu.getTenDangNhap());
            stm.setString(3, chuDichVu.getMatKhau());
            stm.setString(4, chuDichVu.getEmail());
            stm.setString(5, chuDichVu.getSoDienThoai());

            stm.executeUpdate();

//            System.out.println("Insert done!");
            stm.close();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ChuDichVuDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.close();
                System.out.println("Db insert Cdv close");
            } catch (SQLException ex) {
                Logger.getLogger(ChuDichVuDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return false;
    }

    @Override
    public boolean update(ChuDichVu chuDichVu) {
        Connection conn = DatabaseUtils.getConnection();
        String sqlUpdata = "update CHU_DICH_VU set TenCDV = ?, Email = ?, SoDienThoai = ? where TenDangNhap = ?";

        try {
            PreparedStatement stm = conn.prepareStatement(sqlUpdata);

            stm.setString(1, chuDichVu.getHoVaTen());
            stm.setString(2, chuDichVu.getEmail());
            stm.setString(3, chuDichVu.getSoDienThoai());
            stm.setString(4, chuDichVu.getTenDangNhap());

            stm.executeUpdate();
//            System.out.println("update");
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(ChuDichVuDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ChuDichVuDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return false;

    }

    @Override
    public boolean delete(ChuDichVu chuDichVu) {
        Connection conn = DatabaseUtils.getConnection();
        String sqlDelete = "delete from CHU_DICH_VU where TenDangNhap = ?";

        try {
            PreparedStatement stm = conn.prepareStatement(sqlDelete);

            stm.setString(1, chuDichVu.getTenDangNhap());

            stm.executeUpdate();

            System.out.println("delete");
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(ChuDichVuDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ChuDichVuDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return false;

    }

    @Override
    public List<ChuDichVu> selectAll() {
        Connection conn = DatabaseUtils.getConnection();
        List<ChuDichVu> chuDichVus = new ArrayList<>();
        String sqlSelect = "select * from CHU_DICH_VU";
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sqlSelect);

            while (rs.next()) {
                String ten = rs.getString("TenCDV");
                String tenDangNhap = rs.getString("TenDangNhap");
                String matKhau = rs.getString("MatKhau");
                String email = rs.getString("Email");
                String sdt = rs.getString("SoDienThoai");
                ChuDichVu cdv = new ChuDichVu(ten, tenDangNhap, matKhau, email, sdt);
                chuDichVus.add(cdv);
            }

            stm.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ChuDichVuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return chuDichVus;
    }

    @Override
    public ChuDichVu selectByTenDangNhap(ChuDichVu chuDichVu) {
        Connection connection = DatabaseUtils.getConnection();
        String sql = "select * from CHU_DICH_VU where TenDangNhap = ?";
        
        ChuDichVu cdv = new ChuDichVu();
        
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            
            stm.setString(1, chuDichVu.getTenDangNhap());
            
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                String ten = rs.getString("TenCDV");
                String tenDangNhap = rs.getString("TenDangNhap");
                String matKhau = rs.getString("MatKhau");
                String email = rs.getString("Email");
                String sdt = rs.getString("SoDienThoai");
                cdv.setHoVaTen(ten);
                cdv.setTenDangNhap(tenDangNhap);
                cdv.setMatKhau(matKhau);
                cdv.setEmail(email);
                cdv.setSoDienThoai(sdt);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ChuDichVuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(ChuDichVuDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return cdv;
    }

}
