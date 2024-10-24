/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myctu.touristmanagementsystem.controller;

import com.myctu.touristmanagementsystem.view.AdminView;

/**
 *
 * @author ASUS
 */
public class AdminController {

    private AdminView adminView;

    public AdminController(AdminView adminView) {
        this.adminView = adminView;
    }

    public AdminView getAdminView() {
        return adminView;
    }

    public void setAdminView(AdminView adminView) {
        this.adminView = adminView;
    }

    public void showAdminView(){
        adminView.setVisible(true);
    }
}
