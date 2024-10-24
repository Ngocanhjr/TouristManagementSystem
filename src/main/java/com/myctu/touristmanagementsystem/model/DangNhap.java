/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myctu.touristmanagementsystem.model;

/**
 *
 * @author ASUS
 */
public class DangNhap {
    private String tenDangNhap;
    
    private String matKhau;
    
    private String role;

    public DangNhap() {
    }

    public DangNhap(String tenDangNhap, String matKhau) {
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
    }

    
    public DangNhap(String tenDangNhap, String matKhau, String role) {
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.role = role;
    }

   
    
    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    
}
