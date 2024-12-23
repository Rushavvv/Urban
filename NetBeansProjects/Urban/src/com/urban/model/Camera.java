/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.urban.model;

/**
 *
 * @author rushav
 */
public class Camera {
    private int id;  
    private int price;            
    private int stock; 
    private String resolution;
    private String name;
    private String date;
    
    public Camera(){
        
    }
    
    public Camera(int id, String name, int price, int stock, String resolution, String date){
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.resolution = resolution;
        this.date = date;
             
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }
    
    public String getResolution() {
        return resolution;
    }

    public String getName() {
        return name;
    }
    
    public String getDate() {
        return date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setDate(String date) {
        this.date = date;
    }      
    
}


