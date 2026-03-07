package com.leiqjl;

/**
 * 1758. Minimum Changes To Make Alternating Binary String - Easy
 */
public class MinimumChangesToMakeAlternatingBinaryString {
    public int minOperations(String s) {
        int n = s.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if ((i & 1) == 1) {
                if (s.charAt(i) == '1') {
                    count++;
                }
            } else {
                if (s.charAt(i) == '0') {
                    count++;
                }
            }
        }
        return Math.min(count, n - count);
    }
}
