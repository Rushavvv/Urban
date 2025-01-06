/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.urban.controller;
import java.util.List;
import com.urban.model.Camera;
/**
 * Utility class for validating various attributes of Camera objects.
 *
 * @author rushavSthapit
 * LMU_ID: 23048581
 */
public class BinarySearch {

    public Camera searchByName(String searchValue, List<Camera> camList,
        int left, int right) {
        // Base Case
        if (right < left) {
            return null;
        }

        // mid value
        int mid = (left + right) / 2;

        // checks whether searchKey lies on mid point
        if (searchValue.compareToIgnoreCase(camList.get(mid).getName()) == 0) {
            return camList.get(mid);
        } else if (searchValue.compareToIgnoreCase(camList.get(mid).getName()) < 0) {
            return searchByName(searchValue, camList, left, mid - 1);
        } else {
            return searchByName(searchValue, camList, mid + 1, right);
        }

    }
}
