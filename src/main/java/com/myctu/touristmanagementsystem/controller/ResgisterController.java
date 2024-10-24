/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myctu.touristmanagementsystem.controller;

import com.myctu.touristmanagementsystem.view.LoginView;
import com.myctu.touristmanagementsystem.view.ResgisterView;

/**
 *
 * @author GIGABYTE
 */
public class ResgisterController {
    private ResgisterView ResgisterView ;
    
    private LoginView loginView;

    public ResgisterController(ResgisterView ResgisterView, LoginView loginView) {
        this.ResgisterView = ResgisterView;
        this.loginView = loginView;
    }

    public ResgisterController() {
    }

    public  void showResgisterView(){
        ResgisterView.setVisible(true);
    }
    
}
