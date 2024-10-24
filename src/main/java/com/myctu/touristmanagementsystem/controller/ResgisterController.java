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
    private ResgisterView resgisterView ;
    
    private LoginView loginView;

    public ResgisterController(ResgisterView resgisterView) {
        this.resgisterView = resgisterView;
    }

    public  void showResgisterView(){
        this.resgisterView.setVisible(true);
    }
    
}
