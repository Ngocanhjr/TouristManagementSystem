/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myctu.touristmanagementsystem.test;

import com.myctu.touristmanagementsystem.controller.LoginController;
import com.myctu.touristmanagementsystem.view.LoginView;
import java.awt.EventQueue;

/**
 *
 * @author ASUS
 */
public class TestLoginControler {
    public static void main(String[] args) {
          EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                 
                LoginView newView = new LoginView();

                LoginController control = new LoginController(newView);

                control.showLoginView();
            }
        });
    }
}
