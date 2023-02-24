package com.leiqjl;

import java.util.PriorityQueue;

/**
 * 1675. Minimize Deviation in Array - Hard
 * You are given an array nums of n positive integers.
 * <p>
 * You can perform two types of operations on any element of the array any number of times:
 * <p>
 * - If the element is even, divide it by 2.
 * - For example, if the array is [1,2,3,4], then you can do this operation on the last element, and the array will be [1,2,3,2].
 * - If the element is odd, multiply it by 2.
 * - For example, if the array is [1,2,3,4], then you can do this operation on the first element, and the array will be [2,2,3,4].
 * <p>
 * The deviation of the array is the maximum difference between any two elements in the array.
 * <p>
 * Return the minimum deviation the array can have after performing some number of operations.
 */
public class MinimizeDeviationInArray {
    //Constraints:
    //
    //n == nums.length
    //2 <= n <= 5 * 10^4
    //1 <= nums[i] <= 10^9
    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            while (num % 2 == 1) {
                num *= 2;
            }
            maxHeap.offer(num);
            min = Math.min(min, num);
        }
        int result = Integer.MAX_VALUE;
        while (maxHeap.peek() % 2 == 0) {
            result = Math.min(result, maxHeap.peek() - min);
            int tmp = maxHeap.peek() / 2;
            min = Math.min(min, tmp);
            maxHeap.poll();
            maxHeap.offer(tmp);
        }
        return Math.min(result, maxHeap.peek() - min);
    }

    public static void main(String[] args) {
        MinimizeDeviationInArray m = new MinimizeDeviationInArray();
        //Input: nums = [1,2,3,4]
        //Output: 1
        //Explanation: You can transform the array to [1,2,3,2], then to [2,2,3,2], then the deviation will be 3 - 2 = 1.
        assert m.minimumDeviation(new int[]{1, 2, 3, 4}) == 1;
        //Input: nums = [4,1,5,20,3]
        //Output: 3
        //Explanation: You can transform the array after two operations to [4,2,5,5,3], then the deviation will be 5 - 2 = 3.
        assert m.minimumDeviation(new int[]{4, 1, 5, 20, 3}) == 3;
        //Input: nums = [2,10,8]
        //Output: 3
        assert m.minimumDeviation(new int[]{2, 10, 8}) == 3;
        assert m.minimumDeviation(new int[]{4, 9, 4, 5}) == 5;
    }
}
