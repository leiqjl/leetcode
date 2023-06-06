package com.leiqjl;

import java.util.Arrays;

/**
 * 1502. Can Make Arithmetic Progression From Sequence - Easy
 * A sequence of numbers is called an arithmetic progression if the difference between any two consecutive elements is the same.
 * <p>
 * Given an array of numbers arr, return true if the array can be rearranged to form an arithmetic progression. Otherwise, return false.
 */
public class CanMakeArithmeticProgressionFromSequence {
    //Constraints:
    //
    //2 <= arr.length <= 1000
    //-10^6 <= arr[i] <= 10^6
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int diff = arr[1] - arr[0];
        for (int i = 2; i < arr.length; i++) {
            if ((arr[i] - arr[i - 1]) != diff) {
                return false;
            }
        }
        return true;
    }
}
