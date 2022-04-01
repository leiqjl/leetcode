package com.leiqjl;

/**
 * 557. Reverse Words in a String III - Easy
 * <p>
 * Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 */
public class ReverseStringIII {

    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int i = 0, j = 0;
        while (j <= chars.length) {
            if (j == chars.length || chars[j] == ' ') {
                reverseStr(chars, i, j - 1);
                i = j + 1;
            }
            j++;
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
