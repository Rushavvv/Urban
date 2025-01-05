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
 * @author rushavSthapit
 * LMU_ID: 23048581
 */
/**
 * Class to perform merge sort on a list of Camera objects based on stock quantity.
 *
 * @author rushavSthapit
 * LMU_ID: 23048581
 */
public class MergeSort {

    /**
     * Sorts a list of Camera objects by stock in ascending order.
     *
     * @param cameraList the list of Camera objects to be sorted
     * @return the sorted list in ascending order
     */
    public List<Camera> sortByStockAscending(List<Camera> cameraList) {
        return mergeSort(cameraList, true);
    }

    /**
     * Sorts a list of Camera objects by stock in descending order.
     *
     * @param cameraList the list of Camera objects to be sorted
     * @return the sorted list in descending order
     */
    public List<Camera> sortByStockDescending(List<Camera> cameraList) {
        return mergeSort(cameraList, false);
    }

    /**
     * Core merge sort logic to sort a list of Camera objects.
     *
     * @param cameraList the list of Camera objects to be sorted
     * @param ascending specifies whether to sort in ascending (true) or descending (false) order
     * @return the sorted list
     */
    private List<Camera> mergeSort(List<Camera> cameraList, boolean ascending) {
        if (cameraList.size() <= 1) {
            return cameraList; // Base case: a list with one or no elements is already sorted
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

    /**
     * Merges two sorted lists into a single sorted list.
     *
     * @param left the left half of the list
     * @param right the right half of the list
     * @param ascending specifies whether to merge in ascending (true) or descending (false) order
     * @return the merged and sorted list
     */
    private List<Camera> merge(List<Camera> left, List<Camera> right, boolean ascending) {
        List<Camera> merged = new ArrayList<>();
        int i = 0, j = 0;

        // Merge elements from both lists while both have remaining elements
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

    /**
     * Determines whether the current Camera object should be swapped based on stock.
     *
     * @param a the first Camera object to compare
     * @param b the second Camera object to compare
     * @param ascending specifies whether to sort in ascending (true) or descending (false) order
     * @return true if the objects should be swapped, false otherwise
     */
    private boolean shouldSwap(Camera a, Camera b, boolean ascending) {
        return ascending ? a.getStock() <= b.getStock() : a.getStock() > b.getStock();
    }
}
