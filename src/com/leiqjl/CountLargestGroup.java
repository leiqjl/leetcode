package com.leiqjl;

/**
 * 1399. Count Largest Group - Easy
 * You are given an integer n.
 * <p>
 * Each number from 1 to n is grouped according to the sum of its digits.
 * <p>
 * Return the number of groups that have the largest size
 */
public class CountLargestGroup {
    //1 <= n <= 10^4
    //9999
    public int countLargestGroup(int n) {
        int[] freq = new int[37];
        int max = 0;
        for (int i = 1; i <= n; i++) {
            int sum = digitsSum(i);
            freq[sum]++;
            max = Math.max(max, freq[sum]);
        }
        int count = 0;
        for (int i = 1; i < freq.length; i++) {
            if (freq[i] == max) {
                count++;
            }
        }
        return count;
    }

    private int digitsSum(int num) {
        int sum = 0;
        while (num != 0) {
            sum += (num % 10);
            num /= 10;
        }
        return sum;
    }
}
