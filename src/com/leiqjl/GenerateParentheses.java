package com.leiqjl;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. Generate Parentheses - Medium
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 */
public class GenerateParentheses {
    //1 <= n <= 8
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesisHelper(result, "", 0, 0, n);
        return result;
    }

    private void generateParenthesisHelper(List<String> result, String s, int open, int close, int n) {
        if (s.length() == n * 2) {
            result.add(s);
            return;
        }
        if (open < n) {
            generateParenthesisHelper(result, s + "(", open + 1, close, n);
        }
        if (close < open) {
            generateParenthesisHelper(result, s + ")", open, close + 1, n);
        }
    }

}
