package com.leiqjl;

/**
 * 2864. Maximum Odd Binary Number - Easy
 */
public class MaximumOddBinaryNumber {
    public String maximumOddBinaryNumber(String s) {
        int n = s.length();
        int l = 0, r = n - 1;
        char[] chars = s.toCharArray();
        while (l <= r) {
            if (chars[l] == '1') {
                l++;
            }
            if (chars[r] == '0') {
                r--;
            }
            if (l <= r && chars[l] == '0' && chars[r] == '1') {
                chars[l] = '1';
                chars[r] = '0';
            }
        }
        chars[l - 1] = '0';
        chars[n - 1] = '1';
        return new String(chars);
    }
}
