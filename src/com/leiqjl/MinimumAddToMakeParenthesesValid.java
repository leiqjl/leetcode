package com.leiqjl;

/**
 * 921. Minimum Add to Make Parentheses Valid - Medium
 */
public class MinimumAddToMakeParenthesesValid {
    public int minAddToMakeValid(String s) {
        int left = 0, needAdd = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                left++;
            } else if (c == ')') {
                if (left > 0) {
                    left--;
                } else {
                    needAdd++;
                }
            }
        }
        return needAdd + left;
    }
}
