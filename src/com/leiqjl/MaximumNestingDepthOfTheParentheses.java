package com.leiqjl;

/**
 * 1614. Maximum Nesting Depth of the Parentheses -Easy
 */
public class MaximumNestingDepthOfTheParentheses {
    public int maxDepth(String s) {
        int res = 0, count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
            }
            res = Math.max(res, count);
        }
        return res;
    }
}
