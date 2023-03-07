package com.leiqjl;

/**
 * 1539. Kth Missing Positive Number - Easy
 * Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.
 *
 * Return the kth positive integer that is missing from this array.
 */
public class KthMissingPositiveNumber {
    //Constraints:
    //
    //1 <= arr.length <= 1000
    //1 <= arr[i] <= 1000
    //1 <= k <= 1000
    //arr[i] < arr[j] for 1 <= i < j <= arr.length
    public int findKthPositive(int[] arr, int k) {
        int i = 0, count = 0;
        for (int num = 1; num <= (k + arr.length); num++) {
            if (i < arr.length && arr[i] == num) {
                i++;
            } else {
                count++;
            }
            if (count == k) {
                return num;
            }
        }
        return -1;
    }
}
