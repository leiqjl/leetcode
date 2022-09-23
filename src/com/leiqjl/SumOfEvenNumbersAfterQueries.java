package com.leiqjl;

import java.util.Arrays;

/**
 * 985. Sum of Even Numbers After Queries - Medium
 */
public class SumOfEvenNumbersAfterQueries {

    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int sum = 0;
        for (int n : nums) {
            if ((n & 1) == 0) {
                sum += n;
            }
        }
        int[] answer = new int[nums.length];
        for (int i = 0; i < queries.length; i++) {
            int idx = queries[i][1];
            int val = queries[i][0];
            if ((nums[idx] & 1) == 0) {
                sum -= nums[idx];
            }
            nums[idx] += val;
            if ((nums[idx] & 1) == 0) {
                sum += nums[idx];
            }
            answer[i] = sum;
        }
        return answer;
    }

    public static void main(String[] args) {
        SumOfEvenNumbersAfterQueries s = new SumOfEvenNumbersAfterQueries();
        //Input: nums = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]]
        //Output: [8,6,2,4]
        int[] nums = {1, 2, 3, 4};
        int[][] queries = {{1, 0}, {-3, 1}, {-4, 0}, {2, 3}};
        assert Arrays.equals(s.sumEvenAfterQueries(nums, queries), new int[]{8, 6, 2, 4});
        //Input: nums = [1], queries = [[4,0]]
        //Output: [0]
        int[] nums1 = {1};
        int[][] queries1 = {{4, 0}};
        assert Arrays.equals(s.sumEvenAfterQueries(nums1, queries1), new int[]{0});
    }
}
