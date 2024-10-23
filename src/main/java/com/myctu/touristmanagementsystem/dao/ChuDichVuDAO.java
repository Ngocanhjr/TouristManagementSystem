/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myctu.touristmanagementsystem.dao;

import com.myctu.touristmanagementsystem.database.DatabaseUtils;
import com.myctu.touristmanagementsystem.model.ChuDichVu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
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
            System.out.println("delete");
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(ChuDichVuDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
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
        String sqlSelect  
        List<ChuDichVu> chuDichVus = new ArrayList<>();
        
        
        return chuDichVus;
    }

}
