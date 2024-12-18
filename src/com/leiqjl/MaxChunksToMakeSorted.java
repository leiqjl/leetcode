package com.leiqjl;

/**
 * 769. Max Chunks To Make Sorted - Medium
 * You are given an integer array arr of length n that represents a permutation of the integers in the range [0, n - 1].
 * <p>
 * We split arr into some number of chunks (i.e., partitions), and individually sort each chunk. After concatenating them, the result should equal the sorted array.
 * <p>
 * Return the largest number of chunks we can make to sort the array.
 */
public class MaxChunksToMakeSorted {
    public int maxChunksToSorted(int[] arr) {
        int max = 0, count = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if (max == i) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        MaxChunksToMakeSorted m = new MaxChunksToMakeSorted();
        //Input: arr = [4,3,2,1,0]
        //Output: 1
        assert m.maxChunksToSorted(new int[]{4, 3, 2, 1, 0}) == 1;
        //Input: arr = [1,0,2,3,4]
        //Output: 4
        assert m.maxChunksToSorted(new int[]{1, 0, 2, 3, 4}) == 4;
        assert m.maxChunksToSorted(new int[]{1, 2, 0, 3}) == 2;
    }
}
