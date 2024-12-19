package com.leiqjl;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 907. Sum of Subarray Minimums - Medium
 * Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr.
 * Since the answer may be large, return the answer modulo 10^9 + 7.
 */
public class SumOfSubarrayMinimums {

    public int sumSubarrayMins1(int[] arr) {
        int mod = 1000000007;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            sum += min;
            for (int j = i + 1; j < arr.length; j++) {
                min = Math.min(min, arr[j]);
                sum += min;
                sum %= mod;
            }
        }
        return sum;
    }

    public int sumSubarrayMins(int[] arr) {
        int mod = 1000000007;
        Deque<Integer> leftStack = new ArrayDeque<>();
        Deque<Integer> rightStack = new ArrayDeque<>();
        int[] left = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            left[i] = i + 1;
        }
        int[] right = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            right[i] = arr.length - i;
        }
        for (int i = 0; i < arr.length; i++) {
            while (!leftStack.isEmpty() && arr[leftStack.peek()] > arr[i]) {
                leftStack.pop();
            }
            if (!leftStack.isEmpty()) {
                left[i] = i - leftStack.peek();
            }
            leftStack.push(i);
            while (!rightStack.isEmpty() && arr[rightStack.peek()] > arr[i]) {
                int pop = rightStack.pop();
                right[pop] = i - pop;
            }
            rightStack.push(i);
        }
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = (sum + (long) left[i] * right[i] * arr[i]) % mod;
        }
        return (int) (sum % mod);
    }

    public static void main(String[] args) {
        SumOfSubarrayMinimums s = new SumOfSubarrayMinimums();
        //Input: arr = [3,1,2,4] 1*1*3 2*3*1  1*2*2 1*1*4
        //Output: 17
        assert s.sumSubarrayMins(new int[]{3, 1, 2, 4}) == 17;
        //Input: arr = [11,81,94,43,3]
        //Output: 444
        assert s.sumSubarrayMins(new int[]{11, 81, 94, 43, 3}) == 444;
    }
}
