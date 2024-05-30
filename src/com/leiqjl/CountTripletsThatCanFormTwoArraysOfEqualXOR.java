package com.leiqjl;

import java.util.HashMap;
import java.util.Map;

/**
 * 1442. Count Triplets That Can Form Two Arrays of Equal XOR - Medium
 * <p>
 * Given an array of integers arr.
 * We want to select three indices i, j and k where (0 <= i < j <= k < arr.length).
 * Let's define a and b as follows:
 * - a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1]
 * - b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k]
 * Note that ^ denotes the bitwise-xor operation.
 * Return the number of triplets (i, j and k) Where a == b.
 */
public class CountTripletsThatCanFormTwoArraysOfEqualXOR {


    // time O(n), space O(n)
    // i=i1,i2,i3,...,im, Si=Sk+1
    // (k-i1)+(k-i2)+(k-i3)+...+(k-im) = k*m-(i1+i2+i3+...+im)
    public int countTriplets(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> countMap = new HashMap<>();
        Map<Integer, Integer> sumMap = new HashMap<>();
        int count = 0, xor = 0;
        for (int i = 0; i < n; i++) {
            int temp = xor ^ arr[i];
            if (countMap.containsKey(temp)) {
                count = count + countMap.get(temp) * i - sumMap.get(temp);
            }
            countMap.put(xor, countMap.getOrDefault(xor, 0) + 1);
            sumMap.put(xor, sumMap.getOrDefault(xor, 0) + i);
            xor = temp;
        }
        return count;
    }

    // time O(n2), space O(n)
    public int countTriplets1(int[] arr) {
        int n = arr.length;
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] ^ arr[i];
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int k = i + 1; k < n; k++) {
                // (prefix[j]^prefix[i]) ^ (prefix[k+1]^prefix[j]) = 0
                // prefix[i] = prefix[k+1]
                // j ∈ (i,k]
                if (prefix[i] == prefix[k + 1]) {
                    count += (k - i);
                }
            }
        }
        return count;
    }

    // time O(n3), space O(n)
    public int countTriplets2(int[] arr) {
        int n = arr.length;
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] ^ arr[i];
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j; k < n; k++) {
                    if (prefix[i] == prefix[k + 1]) {
                        count++;
                    }
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
        CountTripletsThatCanFormTwoArraysOfEqualXOR c = new CountTripletsThatCanFormTwoArraysOfEqualXOR();
        //Input: arr = [2,3,1,6,7]
        //Output: 4
        //Explanation: The triplets are (0,1,2), (0,2,2), (2,3,4) and (2,4,4)
        assert c.countTriplets(new int[]{2, 3, 1, 6, 7}) == 4;

        //Input: arr = [1,1,1,1,1]
        //Output: 10
        assert c.countTriplets(new int[]{1, 1, 1, 1, 1}) == 10;
    }
}
