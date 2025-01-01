/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.urban.controller;
import com.urban.model.Camera;
import java.util.List;

/**
 *
 * @author rushav
 */
public class InsertionSort {
    public InsertionSort(){
    
    }
    // Method to sort names alphabetically using insertion sort
   public List<Camera> sortAlphabetically(List<Camera> cameraList) {
       System.out.println("3");
        return sort(cameraList, true);
    }

    // Public method to sort the list of Camera objects in reverse alphabetical order
    public List<Camera> sortReverseAlphabetically(List<Camera> cameraList) {
        System.out.println("4");
        return sort(cameraList, false);
    }

    // Core sort method with a toggle for ascending/descending order
    private List<Camera> sort(List<Camera> cameraList, boolean ascending) {
        System.out.println("6");
        for (int i = 1; i < cameraList.size(); i++) {
            Camera key = cameraList.get(i);
            int insertPosition = findInsertPosition(cameraList, key, i, ascending);
            shiftRight(cameraList, insertPosition, i);
            cameraList.set(insertPosition, key);
        }
        return cameraList;
    }

    // Helper method to find the correct position for the current key
    private int findInsertPosition(List<Camera> cameraList, Camera key, int endIndex, boolean ascending) {
        System.out.println("7");
        int j = endIndex - 1;
        while (j >= 0 && shouldSwap(cameraList.get(j), key, ascending)) {
            j--;
        }
        return j + 1; // Return the insert position
    }

    // Helper method to determine if swapping is needed
    private boolean shouldSwap(Camera a, Camera b, boolean ascending) {
        System.out.println("8");
        int comparison = a.getName().compareTo(b.getName());
        return ascending ? comparison > 0 : comparison < 0;
    }

    // Helper method to shift elements to the right to make space for the key
    private void shiftRight(List<Camera> cameraList, int start, int end) {
        System.out.println("9");
        for (int k = end; k > start; k--) {
            cameraList.set(k, cameraList.get(k - 1));
        }
    }
}
