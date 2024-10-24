/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myctu.touristmanagementsystem.controller;

import com.myctu.touristmanagementsystem.view.AdminView;
import com.myctu.touristmanagementsystem.view.UserView;

/**
 *
 * @author ASUS
 */
public class UserController {
   private UserView userView;

    public UserController(UserView userView) {
        this.userView = userView;
    }

    public UserView getUserView() {
        return userView;
    }

    public void setUserView(UserView userView) {
        this.userView = userView;
    }
    public void showUserView(){
        userView.setVisible(true);
    }
    
}
