/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.urban.controller;
import com.urban.model.Camera;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;


/**
 * Utility class for validating various attributes of Camera objects.
 *
 * @author rushavSthapit
 * LMU_ID: 23048581
 */
public class ValidationUtil extends Camera {
    List<String> store = new ArrayList<>();

    /**
     * Validates if the camera ID is within the range of 100000 to 999999.
     *
     * @param camId the camera ID to validate
     * @return true if the ID is in range, false otherwise
     */
    public static boolean isIdInRange(String camId) {
        try {
            int id = Integer.parseInt(camId);

            if (id < 100000 || id > 999999) {
                return false;
            }

            return true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Id Is Not Valid", "Invalid ID", JOptionPane.ERROR_MESSAGE);
            return true;
        }
    }

    /**
     * Validates if the camera ID starts with "13" followed by four digits.
     *
     * @param camId the camera ID to validate
     * @return true if the ID starts correctly, false otherwise
     */
    public static boolean isIdStartCorrect(String camId) {
        try {
            if (!camId.matches("^13\\d{4}$")) {
                return false;
            }
            return true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "LMU Id Is Not Valid", "Invalid College ID", JOptionPane.ERROR_MESSAGE);
            return true;
        }
    }

    /**
     * Validates if the name contains only alphabets and spaces.
     *
     * @param name the name to validate
     * @return true if the name is valid, false otherwise
     */
    public static boolean isNameValid(String name) {
        return name.matches("^[a-zA-Z ]+$");
    }

    /**
     * Checks if a given string is numeric.
     *
     * @param num the string to check
     * @return true if the string is numeric, false otherwise
     */
    public static boolean isnum(String num) {
        try {
            Integer.parseInt(num);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Validates if the price is within the range of 70000 to 500000.
     *
     * @param price the price to validate
     * @return true if the price is valid, false otherwise
     */
    public static boolean isPriceValid(String price) {
        try {
            int pri = Integer.parseInt(price);

            if (pri < 70000 || pri > 500000) {
                return false;
            }

            return true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Price Invalid", "Invalid Price", JOptionPane.ERROR_MESSAGE);
            return true;
        }
    }

    /**
     * Validates if the stock is within the permissible limit (up to 20).
     *
     * @param stock the stock to validate
     * @return true if the stock is valid, false otherwise
     */
    public static boolean isStockEnough(String stock) {
        try {
            int stoc = Integer.parseInt(stock);

            if (stoc > 20) {
                return false;
            }

            return true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Stock Invalid", "Invalid Stock", JOptionPane.ERROR_MESSAGE);
            return true;
        }
    }

    /**
     * Validates if the resolution is within the range of 10 to 100 megapixels.
     *
     * @param resolution the resolution to validate
     * @return true if the resolution is valid, false otherwise
     */
    public static boolean isResolutionInRange(String resolution) {
        try {
            int reso = Integer.parseInt(resolution);

            if (reso < 10 || reso > 100) {
                return false;
            }

            return true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Megapixel Invalid", "Invalid Megapixels", JOptionPane.ERROR_MESSAGE);
            return true;
        }
    }

    /**
     * Placeholder for validating storage (currently always returns true).
     *
     * @param Storage the storage to validate
     * @return true if the storage is valid, false otherwise
     */
    public static boolean isStorageValid(String Storage) {
        try {
            return true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Storage Invalid", "Invalid Storage", JOptionPane.ERROR_MESSAGE);
            return true;
        }
    }

    /**
     * Checks if a given value is empty or null.
     *
     * @param value the value to check
     * @return true if the value is empty or null, false otherwise
     */
    public static boolean IsEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }
}
