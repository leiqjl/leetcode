package com.leiqjl;

/**
 * 344. Reverse String - Easy
 * Write a function that reverses a string. The input string is given as an array of characters s.
 * <p>
 * You must do this by modifying the input array in-place with O(1) extra memory.
 */
public class ReverseString {
    public void reverseString(char[] s) {
        if (s == null || s.length <= 1) {
            return;
        }
        int begin = 0, end = s.length - 1;
        while (begin < end) {
            char c = s[begin];
            s[begin] = s[end];
            s[end] = c;
            begin++;
            end--;
        }
    }
}
