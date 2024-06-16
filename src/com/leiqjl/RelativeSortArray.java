package com.leiqjl;

/**
 * 1122. Relative Sort Array - Easy
 * Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.
 *
 * Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2.
 * Elements that do not appear in arr2 should be placed at the end of arr1 in ascending order.
 *
 */
public class RelativeSortArray {
    //1 <= arr1.length, arr2.length <= 1000
    //0 <= arr1[i], arr2[i] <= 1000
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length];
        int[] countArr = new int[1001];
        for (int i = 0; i < arr1.length; i++) {
            countArr[arr1[i]]++;
        }
        int idx = 0;
        for (int i = 0; i < arr2.length; i++) {
            while (countArr[arr2[i]] > 0) {
                result[idx++] = arr2[i];
                countArr[arr2[i]]--;
            }
        }
        for (int i = 0; i < countArr.length; i++) {
            while (countArr[i] > 0) {
                result[idx++] = i;
                countArr[i]--;
            }
        }
        return result;
    }
}
