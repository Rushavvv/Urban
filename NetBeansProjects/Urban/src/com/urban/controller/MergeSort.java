/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.urban.controller;
import com.urban.model.Camera;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rushav
 */
public class MergeSort {
    public List<Camera> sortByStockAscending(List<Camera> cameraList) {
        return mergeSort(cameraList, true);
    }

    // Sorts the list by stock in descending order
    public List<Camera> sortByStockDescending(List<Camera> cameraList) {
        return mergeSort(cameraList, false);
    }

    // Core merge sort logic with ascending/descending toggle
    private List<Camera> mergeSort(List<Camera> cameraList, boolean ascending) {
        if (cameraList.size() <= 1) {
            return cameraList; // Base case
        }

        // Divide the list into two halves
        int mid = cameraList.size() / 2;
        List<Camera> left = new ArrayList<>(cameraList.subList(0, mid));
        List<Camera> right = new ArrayList<>(cameraList.subList(mid, cameraList.size()));

        // Recursively sort both halves
        left = mergeSort(left, ascending);
        right = mergeSort(right, ascending);

        // Merge the sorted halves
        return merge(left, right, ascending);
    }

    // Merge two sorted lists into one
    private List<Camera> merge(List<Camera> left, List<Camera> right, boolean ascending) {
        List<Camera> merged = new ArrayList<>();
        int i = 0, j = 0;

        // Merge while both lists have elements
        while (i < left.size() && j < right.size()) {
            if (shouldSwap(left.get(i), right.get(j), ascending)) {
                merged.add(left.get(i));
                i++;
            } else {
                merged.add(right.get(j));
                j++;
            }
        }

        // Add remaining elements from the left list
        while (i < left.size()) {
            merged.add(left.get(i));
            i++;
        }

        // Add remaining elements from the right list
        while (j < right.size()) {
            merged.add(right.get(j));
            j++;
        }

        return merged;
    }

    // Determines if the elements should be swapped based on stock
    private boolean shouldSwap(Camera a, Camera b, boolean ascending) {
        return ascending ? a.getStock() <= b.getStock() : a.getStock() > b.getStock();
    }
}
