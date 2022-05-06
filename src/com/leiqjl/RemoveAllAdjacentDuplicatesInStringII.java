package com.leiqjl;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1209. Remove All Adjacent Duplicates in String II - Medium
 */
public class RemoveAllAdjacentDuplicatesInStringII {

    public String removeDuplicates1(String s, int k) {
        Deque<Pair<Character, Integer>> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek().getK() == c) {
                stack.peek().setV(stack.peek().getV() + 1);
            } else {
                stack.push(new Pair<>(c, 1));
            }
            if (stack.peek().getV() == k) {
                stack.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            Pair<Character, Integer> pop = stack.pop();
            sb.append(String.valueOf(pop.getK()).repeat(Math.max(0, pop.getV())));
        }
        return sb.reverse().toString();
    }

    public String removeDuplicates(String s, int k) {
        int[] cnt = new int[s.length()];
        char[] stack = s.toCharArray();
        int idx = 0;
        for (int i = 0; i < s.length(); i++, idx++) {
            stack[idx] = stack[i];
            if (idx > 0 && stack[idx] == stack[idx - 1]) {
                cnt[idx] = cnt[idx - 1] + 1;
            } else {
                cnt[idx] = 1;
            }

            if (cnt[idx] == k) {
                idx -= k;
            }
        }
        return new String(stack, 0, idx);
    }

    public static void main(String[] args) {
        RemoveAllAdjacentDuplicatesInStringII r = new RemoveAllAdjacentDuplicatesInStringII();
        //Input: s = "abcd", k = 2
        //Output: "abcd"
        String s = "abcd";
        assert "abcd".equals(r.removeDuplicates(s, 2));
        //Input: s = "deeedbbcccbdaa", k = 3
        //Output: "aa"
        String s1 = "deeedbbcccbdaa";
        assert "aa".equals(r.removeDuplicates(s1, 3));
        //Input: s = "pbbcggttciiippooaais", k = 2
        //Output: "ps"
        String s2 = "pbbcggttciiippooaais";
        assert "ps".equals(r.removeDuplicates(s2, 2));
    }

}
