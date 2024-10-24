/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myctu.touristmanagementsystem.controller;

import com.myctu.touristmanagementsystem.dao.ChuDichVuDAO;
import com.myctu.touristmanagementsystem.dao.DangNhapDAO;
import com.myctu.touristmanagementsystem.dao.KhachDuLichDAO;
import com.myctu.touristmanagementsystem.model.DangNhap;
import com.myctu.touristmanagementsystem.view.AdminView;
import com.myctu.touristmanagementsystem.view.LoginView;
import com.myctu.touristmanagementsystem.view.ResgisterView;
import com.myctu.touristmanagementsystem.view.UserView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class LoginController {

    private LoginView loginView;

    private ResgisterView resgisterView;

    private AdminView adminView;

    private UserView userView;

    private ChuDichVuDAO chuDichVuDAO;

    private KhachDuLichDAO khachDuLichDAO;

    public LoginController(LoginView loginView) {
        this.loginView = loginView;
        loginView.addDangNhapListener(new dangNhapListener());
        loginView.addDangKyListener(new dangKyListener());
    }

    public void showLoginView() {
        loginView.setVisible(true);
    }

    public String checkLogin(String tenDangNhap, String MatKhau) { // trả về role
        String role = null; // null : no account
        DangNhapDAO dnDao = new DangNhapDAO();
        if (dnDao.isExistChuDichVu(tenDangNhap)) {
            if (dnDao.validateChuDichVuLogin(tenDangNhap, MatKhau)) {
                System.out.println("check login cdv");
                return "chudichvu";
            } else {
               
                return "err";
            }
        }
        if (dnDao.isExistKhachDuLich(tenDangNhap)) {
            if (dnDao.validateKhachDuLichLogin(tenDangNhap, MatKhau)) {
                System.out.println("check login kdl");
                return "khachdulich";
            } else {
                 System.out.println(" err check login kdl");
                return "err";
            }
        }
        return role;
    }

    private class dangNhapListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            DangNhap dt = loginView.getDangNhap(); // trả về tên và mật khẩu
            if (dt != null) {
                //kiểm tra role để hiện thị lên view
                String ketQua = checkLogin(dt.getTenDangNhap(), dt.getMatKhau());
                switch (ketQua) {
                    case "chudichvu":
                        adminView = new AdminView();
                        AdminController adminController = new AdminController(adminView);
                        adminController.showAdminView();
                        loginView.dispose();
                        break;
                    case "khachdulich":
                        userView = new UserView();
                        UserController userController = new UserController(userView);
                        userController.showUserView();
                        loginView.dispose();
                        break;
                    case "err":
                        JOptionPane.showMessageDialog(loginView, "Mật Khẩu không đúng! Vui lòng nhập lại.");
                        break;
                    case null:
                        JOptionPane.showMessageDialog(loginView, "Tài khoản không tồn tại!");
                        break;
                    default:
                        // Xử lý trường hợp bất ngờ
                        JOptionPane.showMessageDialog(loginView, "Đã xảy ra lỗi, vui lòng thử lại!");
                        break;
                }
            }
        }
    }

    private class dangKyListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            resgisterView = new ResgisterView();
            ResgisterController resgisterController = new ResgisterController(resgisterView);
            resgisterController.showResgisterView();
        }

    }
}
