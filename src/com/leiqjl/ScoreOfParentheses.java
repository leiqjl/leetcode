package com.leiqjl;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 856. Score of Parentheses - Medium
 * Given a balanced parentheses string s, return the score of the string.
 * <p>
 * The score of a balanced parentheses string is based on the following rule:
 * - "()" has score 1.
 * - AB has score A + B, where A and B are balanced parentheses strings.
 * - (A) has score 2 * A, where A is a balanced parentheses string.
 */
public class ScoreOfParentheses {
    public int scoreOfParentheses(String s) {
        int a = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(a);
                a = 0;
            } else {
                a = stack.pop() + Math.max(a * 2, 1);
            }
        }
        return a;
    }
}
