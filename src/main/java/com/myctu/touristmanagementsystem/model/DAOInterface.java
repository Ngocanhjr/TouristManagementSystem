/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myctu.touristmanagementsystem.model;

import java.util.List;

/**
 *
 * @author ASUS
 */
public interface DAOInterface <T>{
    public boolean insert(T t);
    
    public boolean update(T t);
    
    public boolean  delete(T t);
    
    public List <T> sellectAll();
      
}
