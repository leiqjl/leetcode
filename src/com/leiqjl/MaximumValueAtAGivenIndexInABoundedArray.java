package com.leiqjl;

/**
 * 1802. Maximum Value at a Given Index in a Bounded Array - Medium
 */
public class MaximumValueAtAGivenIndexInABoundedArray {
    public int maxValue(int n, int index, int maxSum) {
        int l = 1, r = maxSum;
        while (l < r) {
            int mid = (l + r + 1) / 2;
            if (getSum(index, mid, n) > maxSum) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        return l;
    }

    private long getSum(int index, int val, int n) {
        long sum = 0;
        if (val > index) {
            sum = sum + (long) (val - index + val) * (index + 1) / 2;
        } else {
            sum = sum + (long) (1 + val) * val / 2 + index + 1 - val;
        }
        if (val > n - index) {
            sum = sum + (long) (val + val - (n - 1 - index)) * (n - index) / 2;
        } else {
            sum = sum + (long) (val + 1) * val / 2 + n - index - val;
        }
        return sum - val;
    }

    public static void main(String[] args) {
        MaximumValueAtAGivenIndexInABoundedArray m = new MaximumValueAtAGivenIndexInABoundedArray();
        //Input: n = 4, index = 2,  maxSum = 6
        //Output: 2
        assert m.maxValue(4, 2, 6) == 2;
        //Input: n = 6, index = 1,  maxSum = 10
        //Output: 3
        assert m.maxValue(6, 1, 10) == 3;
        assert m.maxValue(8, 7, 14) == 4;
    }
}
