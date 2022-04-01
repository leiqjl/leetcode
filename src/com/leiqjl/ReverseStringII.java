package com.leiqjl;

/**
 * 541. Reverse String II - Easy
 * Given a string s and an integer k, reverse the first k characters for every 2k characters counting from the start of the string.
 *
 * If there are fewer than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters,
 * then reverse the first k characters and leave the other as original.
 */
public class ReverseStringII {

    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int i = 0;
        while (i < chars.length) {
            int j = Math.min(i + k - 1, chars.length - 1);
            reverseStr(chars, i, j);
            i = i + k * 2;
        }
        return String.valueOf(chars);
    }

    private void reverseStr(char[] chars, int begin, int end) {
        while (begin < end) {
            char c = chars[begin];
            chars[begin] = chars[end];
            chars[end] = c;
            begin++;
            end--;
        }
    }

}
