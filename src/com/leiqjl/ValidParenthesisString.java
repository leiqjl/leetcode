package com.leiqjl;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 678. Valid Parenthesis String - Medium
 */
public class ValidParenthesisString {
    public boolean checkValidString(String s) {
        Deque<Integer> leftDeque = new ArrayDeque<>();
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                leftDeque.push(i);
            } else if (c == '*') {
                deque.push(i);
            } else {
                if (!leftDeque.isEmpty()) {
                    leftDeque.pop();
                } else if (!deque.isEmpty()) {
                    deque.pop();
                } else {
                    return false;
                }
            }
        }
        while (!leftDeque.isEmpty() && !deque.isEmpty()) {
            if (leftDeque.pop() > deque.pop()) {
                return false;
            }
        }
        return leftDeque.isEmpty();
    }
}
