/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.urban.controller;
import com.urban.model.Camera;
import java.util.List;

/**
 * Class to perform insertion sort on a list of Camera objects.
 *
 * @author rushavSthapit
 * LMU_ID: 23048581
 */
public class InsertionSort {

    /**
     * Default constructor for the InsertionSort class.
     */
    public InsertionSort() {
    }

    /**
     * Sorts a list of Camera objects alphabetically by their name in ascending order.
     *
     * @param cameraList the list of Camera objects to be sorted
     * @return the sorted list in ascending order
     */
    public List<Camera> sortAlphabetically(List<Camera> cameraList) {
        return sort(cameraList, true);
    }

    /**
     * Sorts a list of Camera objects in reverse alphabetical order by their name.
     *
     * @param cameraList the list of Camera objects to be sorted
     * @return the sorted list in descending order
     */
    public List<Camera> sortReverseAlphabetically(List<Camera> cameraList) {
        return sort(cameraList, false);
    }

    /**
     * Core sort method to perform insertion sort on the given list.
     *
     * @param cameraList the list of Camera objects to be sorted
     * @param ascending specifies whether to sort in ascending (true) or descending (false) order
     * @return the sorted list
     */
    private List<Camera> sort(List<Camera> cameraList, boolean ascending) {
        for (int i = 1; i < cameraList.size(); i++) {
            Camera key = cameraList.get(i);
            int insertPosition = findInsertPosition(cameraList, key, i, ascending);
            shiftRight(cameraList, insertPosition, i);
            cameraList.set(insertPosition, key);
        }
        return cameraList;
    }

    /**
     * Finds the correct position to insert the current Camera object in the sorted portion of the list.
     *
     * @param cameraList the list of Camera objects
     * @param key the current Camera object to be inserted
     * @param endIndex the index up to which the list is sorted
     * @param ascending specifies whether to sort in ascending (true) or descending (false) order
     * @return the index where the key should be inserted
     */
    private int findInsertPosition(List<Camera> cameraList, Camera key, int endIndex, boolean ascending) {
        int j = endIndex - 1;
        while (j >= 0 && shouldSwap(cameraList.get(j), key, ascending)) {
            j--;
        }
        return j + 1; // Return the insert position
    }

    /**
     * Determines whether the current Camera object should be swapped based on the sort order.
     *
     * @param a the current Camera object in the sorted portion of the list
     * @param b the Camera object to be inserted
     * @param ascending specifies whether to sort in ascending (true) or descending (false) order
     * @return true if the objects should be swapped, false otherwise
     */
    private boolean shouldSwap(Camera a, Camera b, boolean ascending) {
        int comparison = a.getName().compareTo(b.getName());
        return ascending ? comparison > 0 : comparison < 0;
    }

    /**
     * Shifts elements in the list to the right to create space for the key.
     *
     * @param cameraList the list of Camera objects
     * @param start the index where the shifting starts
     * @param end the index where the shifting ends
     */
    private void shiftRight(List<Camera> cameraList, int start, int end) {
        for (int k = end; k > start; k--) {
            cameraList.set(k, cameraList.get(k - 1));
        }
    }
}
