package com.leiqjl;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 402. Remove K Digits - Medium
 */
public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        if (k >= num.length()) {
            return "0";
        }
        if (k == 0) {
            return num;
        }
        Deque<Character> deque = new ArrayDeque<>();
        deque.push(num.charAt(0));
        for (int i = 1; i < num.length(); i++) {
            while (k > 0 && !deque.isEmpty() && deque.peek() > num.charAt(i)) {
                deque.pop();
                k--;
            }
            deque.push(num.charAt(i));
            if (deque.size() == 1 && num.charAt(i) == '0') {
                deque.pop();
            }
        }
        while (k > 0 && !deque.isEmpty()) {
            deque.pop();
            k--;
        }
        if (deque.isEmpty()) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(deque.pop());
        }
        return sb.reverse().toString();
    }
}
