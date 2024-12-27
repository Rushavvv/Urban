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
    private int resolution;
    private int storage;
    private String name;
    private String date;
    
    public Camera(){
        
    }
    
    public Camera(int id, String name, int price, int stock, int resolution, String date, int storage){
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.resolution = resolution;
        this.date = date;
        this.storage = storage;
             
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
    
    public int getResolution() {
        return resolution;
    }

    public String getName() {
        return name;
    }
    
    public String getDate() {
        return date;
    }
    public int getStorage() {
        return storage;
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
    
    public void setResolution(int resolution) {
        this.resolution = resolution;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setDate(String date) {
        this.date = date;
    }  
    
    public void setStorage(int storage) {
        this.storage = storage;
    }
    
    
}


