/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.urban.model;

/**
 * Represents a Camera with various attributes such as ID, price, stock, resolution,
 * storage, name, manufacturing date, and flash support.
 * Provides getter and setter methods to access and modify these attributes.
 *
 * @author rushavSthapit
 * LMU_ID: 23048581
 */
public class Camera {

    /**
     * Unique identifier for the camera.
     */
    private int id;

    /**
     * Price of the camera in the local currency.
     */
    private int price;

    /**
     * Stock quantity of the camera available in the inventory.
     */
    private int stock;

    /**
     * Resolution of the camera in megapixels.
     */
    private int resolution;

    /**
     * Storage capacity of the camera in gigabytes.
     */
    private int storage;

    /**
     * Name or model of the camera.
     */
    private String name;

    /**
     * Manufacturing date of the camera.
     */
    private String date;

    /**
     * Indicates whether the camera has flash support (e.g., "Yes" or "No").
     */
    private String flash;

    /**
     * Default constructor for creating an empty Camera object.
     */
    public Camera() {
    }

    /**
     * Parameterized constructor to initialize a Camera object with specific attributes.
     *
     * @param id          the unique identifier for the camera
     * @param name        the name or model of the camera
     * @param price       the price of the camera
     * @param stock       the stock quantity available
     * @param resolution  the resolution in megapixels
     * @param date        the manufacturing date
     * @param storage     the storage capacity in gigabytes
     * @param flash       indicates flash support (e.g., "Yes" or "No")
     */
    public Camera(int id, String name, int price, int stock, int resolution, String date, int storage, String flash) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.resolution = resolution;
        this.date = date;
        this.storage = storage;
        this.flash = flash;
    }

    /**
     * Gets the unique identifier of the camera.
     *
     * @return the camera ID
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the camera.
     *
     * @param id the camera ID to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the price of the camera.
     *
     * @return the price of the camera
     */
    public int getPrice() {
        return price;
    }

    /**
     * Sets the price of the camera.
     *
     * @param price the price to set
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Gets the stock quantity of the camera.
     *
     * @return the stock quantity
     */
    public int getStock() {
        return stock;
    }

    /**
     * Sets the stock quantity of the camera.
     *
     * @param stock the stock quantity to set
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * Gets the resolution of the camera in megapixels.
     *
     * @return the resolution in megapixels
     */
    public int getResolution() {
        return resolution;
    }

    /**
     * Sets the resolution of the camera in megapixels.
     *
     * @param resolution the resolution to set
     */
    public void setResolution(int resolution) {
        this.resolution = resolution;
    }

    /**
     * Gets the name or model of the camera.
     *
     * @return the name or model
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name or model of the camera.
     *
     * @param name the name or model to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the manufacturing date of the camera.
     *
     * @return the manufacturing date
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets the manufacturing date of the camera.
     *
     * @param date the manufacturing date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Gets the storage capacity of the camera in gigabytes.
     *
     * @return the storage capacity
     */
    public int getStorage() {
        return storage;
    }

    /**
     * Sets the storage capacity of the camera in gigabytes.
     *
     * @param storage the storage capacity to set
     */
    public void setStorage(int storage) {
        this.storage = storage;
    }

    /**
     * Gets whether the camera has flash support.
     *
     * @return "Yes" or "No" indicating flash support
     */
    public String getFlash() {
        return flash;
    }

    /**
     * Sets whether the camera has flash support.
     *
     * @param flash "Yes" or "No" to indicate flash support
     */
    public void setFlash(String flash) {
        this.flash = flash;
    }
}


