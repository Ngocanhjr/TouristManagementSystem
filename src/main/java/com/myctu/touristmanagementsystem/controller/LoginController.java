/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myctu.touristmanagementsystem.controller;

import com.myctu.touristmanagementsystem.dao.ChuDichVuDAO;
import com.myctu.touristmanagementsystem.dao.KhachDuLichDAO;
import com.myctu.touristmanagementsystem.view.AdminView;
import com.myctu.touristmanagementsystem.view.LoginView;
import com.myctu.touristmanagementsystem.view.UserView;

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
    }
    
    public void showLoginView(){
        loginView.setVisible(true);
    }
    
}
