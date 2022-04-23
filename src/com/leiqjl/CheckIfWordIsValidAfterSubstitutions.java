package com.leiqjl;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1003. Check If Word Is Valid After Substitutions - Medium
 */
public class CheckIfWordIsValidAfterSubstitutions {

    //1 <= s.length <= 2 * 104
    //s consists of letters 'a', 'b', and 'c'
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == 'c') {
                if (stack.isEmpty() || stack.peek() != 'b') {
                    return false;
                }
                stack.pop();
                if (stack.isEmpty() || stack.peek() != 'a') {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

}
