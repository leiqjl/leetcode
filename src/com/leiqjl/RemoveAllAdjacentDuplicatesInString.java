package com.leiqjl;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1047. Remove All Adjacent Duplicates In String - Easy
 */
public class RemoveAllAdjacentDuplicatesInString {

    //1 <= s.length <= 105
    //s consists of lowercase English letters.
    public String removeDuplicates1(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public String removeDuplicates(String s) {
        char[] stack = s.toCharArray();
        int idx = 0;
        for (int i = 0; i < stack.length; i++, idx++) {
            stack[idx] = stack[i];
            if (idx > 0 && stack[idx] == stack[idx-1]) {
                idx -= 2;
            }
        }
        return new String(stack, 0, idx);
    }

    public static void main(String[] args) {
        RemoveAllAdjacentDuplicatesInString r = new RemoveAllAdjacentDuplicatesInString();
        //Input: s = "abbaca"
        //Output: "ca"
        String s = "abbaca";
        assert "ca".equals(r.removeDuplicates(s));
        //Input: s = "azxxzy"
        //Output: "ay"
        String s1 = "azxxzy";
        assert "ay".equals(r.removeDuplicates(s1));
    }
}
