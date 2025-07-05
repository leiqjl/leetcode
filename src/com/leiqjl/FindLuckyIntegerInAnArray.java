package com.leiqjl;

/**
 * 1394. Find Lucky Integer in an Array - Easy
 */
public class FindLuckyIntegerInAnArray {
    public int findLucky(int[] arr) {
        int[] freq = new int[501];
        for (int num : arr) {
            freq[num]++;
        }
        for (int i = 500; i >= 1; i--) {
            if (freq[i] == i) {
                return i;
            }
        }
        return -1;
    }
}
