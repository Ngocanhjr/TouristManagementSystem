/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myctu.touristmanagementsystem.controller;

import com.myctu.touristmanagementsystem.dao.ChuDichVuDAO;
import com.myctu.touristmanagementsystem.dao.KhachDuLichDAO;
import com.myctu.touristmanagementsystem.model.DangNhap;
import com.myctu.touristmanagementsystem.view.AdminView;
import com.myctu.touristmanagementsystem.view.LoginView;
import com.myctu.touristmanagementsystem.view.UserView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ASUS
 */
public class LoginController {

    private LoginView loginView;

    private AdminView adminView;

    private UserView userView;

    private ChuDichVuDAO chuDichVuDAO;

    private KhachDuLichDAO khachDuLichDAO;

    public LoginController(LoginView loginView) {
        this.loginView = loginView;
        loginView.addDangNhapListener(new dangNhaplistener());
    }

    
    public void showLoginView() {
        loginView.setVisible(true);
    }

//    public boolean 
    class dangNhaplistener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            DangNhap dt = loginView.getDangNhap();
            if (dt != null) {
                
            }
        }

    }
}
