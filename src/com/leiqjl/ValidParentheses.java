package com.leiqjl;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * 1. Open brackets must be closed by the same type of brackets.
 * 2. Open brackets must be closed in the correct order.
 *
 * Note that an empty string is also considered valid.
 */
public class ValidParentheses {



    public boolean isValid(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                deque.addFirst(')');
            } else if (c == '{') {
                deque.addFirst('}');
            } else if (c == '[') {
                deque.addFirst(']');
            } else if (deque.isEmpty() || deque.removeFirst() != c) {
                return false;
            }
        }
        return deque.isEmpty();
    }

}
