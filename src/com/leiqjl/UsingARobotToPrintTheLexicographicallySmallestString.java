package com.leiqjl;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 2434. Using a Robot to Print the Lexicographically Smallest String - Medium
 */
public class UsingARobotToPrintTheLexicographicallySmallestString {
    public String robotWithString(String s) {

        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();
        char minChar = 'a';
        for (char c : s.toCharArray()) {
            stack.push(c);
            freq[c - 'a']--;
            while (minChar != 'z' && freq[minChar - 'a'] == 0) {
                minChar++;
            }
            while (!stack.isEmpty() && stack.peek() <= minChar) {
                sb.append(stack.pop());
            }
        }
        return sb.toString();
    }
}
