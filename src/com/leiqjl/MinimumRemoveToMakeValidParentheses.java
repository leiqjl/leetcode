package com.leiqjl;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1249. Minimum Remove to Make Valid Parentheses - Medium
 */
public class MinimumRemoveToMakeValidParentheses {

    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder(s);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '(') {
                stack.push(i);
            } else if (sb.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    sb.deleteCharAt(i);
                    i--;
                } else {
                    stack.pop();
                }
            }
        }
        while (!stack.isEmpty()) {
            sb.deleteCharAt(stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MinimumRemoveToMakeValidParentheses m = new MinimumRemoveToMakeValidParentheses();
        //Input: s = "lee(t(c)o)de)"
        //Output: "lee(t(c)o)de"
        //Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
        String s = "lee(t(c)o)de)";
        assert m.minRemoveToMakeValid(s).equals("lee(t(c)o)de");

        //Input: s = "a)b(c)d"
        //Output: "ab(c)d"
        s = "a)b(c)d";
        assert m.minRemoveToMakeValid(s).equals("ab(c)d");

        //Input: s = "))(("
        //Output: ""
        //Explanation: An empty string is also valid.
        s = "))((";
        assert m.minRemoveToMakeValid(s).equals("");
    }
}
