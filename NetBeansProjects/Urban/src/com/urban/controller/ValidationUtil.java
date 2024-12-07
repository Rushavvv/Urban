/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.urban.controller;
import com.urban.model.Camera;
import javax.swing.JOptionPane;
/**
 *
 * @author rushav
 */
public class ValidationUtil extends Camera{
   
    public static boolean isIdValid(String camId) {
        try {
            int id = Integer.parseInt(camId);
            
            if(id < 1000 || id > 9999){
               return false;
            }
            
            return true;
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Id Is Not Valid", "Invalid ID", JOptionPane.ERROR_MESSAGE);  

            return true; 
        }
    }
    
    public static boolean isNameValid(String name) {
         return name.matches("^[a-zA-Z ]+$");
    }
    
    public static boolean isPriceValid(String price) {
        try {
            int pri = Integer.parseInt(price);
            
            if(pri < 70000 || pri > 500000){
               return false;
            }
            
            return true;
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Price Invalid", "Invalid Price", JOptionPane.ERROR_MESSAGE);  

            return true; 
        }
        
    }
    
    public static boolean IsEmpty(String value){
            return value == null || value.trim().isEmpty();
    }
    
}
