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
public class SelectionSort {
    List<Camera> cameraSortList;
    
    public SelectionSort(){
        cameraSortList = new ArrayList<>();
    }
    

    /**
     * Finds the index of the extremum value (minimum or maximum) in the list
     * from the start index.
     *
     * @param camSortList the list of StudentModel objects
     * @param startIndex the index to start searching from
     * @param isDesc specifies whether to find the maximum (true) or minimum
     * (false)
     * @return the index of the extremum value
     */
    private int findExtremumIndex(List<Camera> studentSortList, int startIndex, boolean isDesc) {
        int extremumIndex = startIndex;

        for (int j = startIndex + 1; j < studentSortList.size(); j++) {
            if (shouldSwap(studentSortList.get(j).getId(), studentSortList.get(extremumIndex).getId(), isDesc)) {
                extremumIndex = j;
            }
        }

        return extremumIndex;
    }

    /**
     * Determines whether the current value should replace the current extremum
     * based on sort order.
     *
     * @param current the current value
     * @param extremum the current extremum value
     * @param isDesc specifies the sort order (true for descending, false for
     * ascending)
     * @return true if the current value should replace the extremum; false
     * otherwise
     */
    private boolean shouldSwap(int current, int extremum, boolean isDesc) {
        return isDesc ? current > extremum : current < extremum;
    }

    /**
     * Swaps two elements in the list.
     *
     * @param studentSortList the list of StudentModel objects
     * @param i the index of the first element
     * @param j the index of the second element
     */
    private void swap(List<Camera> studentSortList, int i, int j) {
        Camera temp = studentSortList.get(i);
        studentSortList.set(i, studentSortList.get(j));
        studentSortList.set(j, temp);
    }
    
    
    /**
     * Sorts a list of StudentModel objects by their LMU ID in ascending or
     * descending order.
     *
     * @param camList the list of StudentModel objects to be sorted
     * @param isDesc specifies the sort order (true for descending, false for
     * ascending)
     * @return the sorted list
     */
    public List<Camera> sortById(List<Camera> camList, boolean isDesc) {
        this.cameraSortList.clear();
        this.cameraSortList.addAll(camList);
        if (cameraSortList == null || cameraSortList.isEmpty()) {
            throw new IllegalArgumentException("Item list cannot be null or empty.");
        }

        for (int i = 0; i < cameraSortList.size() - 1; i++) {
            int extremumIndex = findExtremumIndex(cameraSortList, i, isDesc);
            if (i != extremumIndex) {
                swap(cameraSortList, i, extremumIndex);
            }
        }

        return cameraSortList;
    }
}

    

