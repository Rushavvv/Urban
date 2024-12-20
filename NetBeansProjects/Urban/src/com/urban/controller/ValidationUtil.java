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
   
    public static boolean isIdInRange(String camId) {
        try {
            int id = Integer.parseInt(camId);
            
            if(id < 100000 || id > 999999){
               return false;
            }
            
            return true;
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Id Is Not Valid", "Invalid ID", JOptionPane.ERROR_MESSAGE);  

            return true; 
        }
    }
    
    public static boolean isIdStartCorrect(String camId) {
        try {            
            if(!camId.matches("^13\\d{4}$")){
               return false;
            }
            return true;
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "LMU Id Is Not Valid", "Invalid College ID", JOptionPane.ERROR_MESSAGE);  
            return true; 
        }
    }
    
    public static boolean isNameValid(String name) {
         return name.matches("^[a-zA-Z ]+$");
    }
    
    public static boolean isnum(String num){
        try {
            Integer.parseInt(num); 
            return true;           
        } catch (NumberFormatException e) {
            return false;            
        }
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
