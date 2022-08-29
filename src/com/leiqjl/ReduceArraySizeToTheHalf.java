package com.leiqjl;

import java.util.HashMap;
import java.util.Map;

/**
 * 1338. Reduce Array Size to The Half - Medium
 * <p>
 * You are given an integer array arr. You can choose a set of integers and remove all the occurrences of these integers in the array.
 * <p>
 * Return the minimum size of the set so that at least half of the integers of the array are removed.
 */
public class ReduceArraySizeToTheHalf {
    //2 <= arr.length <= 10^5
    //arr.length is even.
    //1 <= arr[i] <= 10^5
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[] bucket = new int[arr.length + 1];
        for (int num : map.values()) {
            bucket[num]++;
        }
        int count = 0, target = arr.length / 2;
        for (int i = bucket.length - 1; i > 0; i--) {
            for (int j = 1; j <= bucket[i]; j++) {
                count++;
                target -= i;
                if (target <= 0) {
                    return count;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        ReduceArraySizeToTheHalf r = new ReduceArraySizeToTheHalf();
        //Input: arr = [3,3,3,3,5,5,5,2,2,7]
        //Output: 2
        int[] arr = {3, 3, 3, 3, 5, 5, 5, 2, 2, 7};
        assert r.minSetSize(arr) == 2;
        //Input: arr = [7,7,7,7,7,7]
        //Output: 1
        int[] arr1 = {7, 7, 7, 7, 7, 7};
        assert r.minSetSize(arr1) == 1;
    }
}
