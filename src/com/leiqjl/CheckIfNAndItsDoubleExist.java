package com.leiqjl;

import java.util.HashMap;
import java.util.Map;

/**
 * 1346. Check If N and Its Double Exist - Easy
 * Given an array arr of integers, check if there exist two indices i and j such that :
 * <p>
 * · i != j
 * · 0 <= i, j < arr.length
 * · arr[i] == 2 * arr[j]
 */
public class CheckIfNAndItsDoubleExist {
    //2 <= arr.length <= 500
    //-10^3 <= arr[i] <= 10^3
    public boolean checkIfExist(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i] << 1) || (arr[i] & 1) == 0 && map.containsKey(arr[i] >> 1)) {
                return true;
            }
            map.put(arr[i], arr[i]);
        }
        return false;
    }
}
