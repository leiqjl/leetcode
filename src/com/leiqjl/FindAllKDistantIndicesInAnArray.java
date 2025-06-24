package com.leiqjl;

import java.util.ArrayList;
import java.util.List;

/**
 * 2200. Find All K-Distant Indices in an Array - Easy
 * You are given a 0-indexed integer array nums and two integers key and k.
 * A k-distant index is an index i of nums for which there exists at least one index j such that |i - j| <= k and nums[j] == key.
 * <p>
 * Return a list of all k-distant indices sorted in increasing order.
 */
public class FindAllKDistantIndicesInAnArray {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        int end = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == key) {
                int start = Math.max(end, i - k);
                end = Math.min(n - 1, i + k);
                for (int j = start; j <= end; j++) {
                    result.add(j);
                }
                end++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FindAllKDistantIndicesInAnArray f = new FindAllKDistantIndicesInAnArray();
        //Input: nums = [3,4,9,1,3,9,5], key = 9, k = 1
        //Output: [1,2,3,4,5,6]
        assert f.findKDistantIndices(new int[]{3, 4, 9, 1, 3, 9, 5}, 9, 1).toString().equals("[1, 2, 3, 4, 5, 6]");
        //Input: nums = [2,2,2,2,2], key = 2, k = 2
        //Output: [0,1,2,3,4]
        assert f.findKDistantIndices(new int[]{2, 2, 2, 2, 2}, 2, 2).toString().equals("[0, 1, 2, 3, 4]");
    }
}
