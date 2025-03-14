package com.leiqjl;

import java.util.HashMap;
import java.util.Map;

/**
 * 1726. Tuple with Same Product - Medium
 * <p>
 * Given an array nums of distinct positive integers, return the number of tuples (a, b, c, d)
 * such that a * b = c * d where a, b, c, and d are elements of nums, and a != b != c != d.
 */
public class TupleWithSameProduct {

    //time O(n^2) space O(n)
    public int tupleSameProduct(int[] nums) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int mult = nums[i] * nums[j];
                int c = map.getOrDefault(mult, 0);
                sum += 8 * c;
                map.put(mult, c + 1);
            }
        }
        return sum;
    }


    public static void main(String[] args) {
        TupleWithSameProduct t = new TupleWithSameProduct();
        //Input: nums = [2,3,4,6]
        //Output: 8
        //(2,6,3,4) , (2,6,4,3) , (6,2,3,4) , (6,2,4,3)
        //(3,4,2,6) , (4,3,2,6) , (3,4,6,2) , (4,3,6,2)
        int[] nums = {2, 3, 4, 6};
        assert t.tupleSameProduct(nums) == 8;
        //Input: nums = [1,2,4,5,10]
        //Output: 16
        //(1,10,2,5) , (1,10,5,2) , (10,1,2,5) , (10,1,5,2)
        //(2,5,1,10) , (2,5,10,1) , (5,2,1,10) , (5,2,10,1)
        //(2,10,4,5) , (2,10,5,4) , (10,2,4,5) , (10,2,5,4)
        //(4,5,2,10) , (4,5,10,2) , (5,4,2,10) , (5,4,10,2)
        int[] nums1 = {1, 2, 4, 5, 10};
        assert t.tupleSameProduct(nums1) == 16;
    }
}
