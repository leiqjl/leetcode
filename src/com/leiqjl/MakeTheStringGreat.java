package com.leiqjl;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1544. Make The String Great - easy
 */
public class MakeTheStringGreat {
    public String makeGood(String s) {
        Deque<Character> deque = new ArrayDeque<>(s.length());
        for (char c : s.toCharArray()) {
            if (!deque.isEmpty() && Math.abs(deque.getLast() - c) == 32) {
                deque.removeLast();
            } else {
                deque.addLast(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(deque.removeFirst());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MakeTheStringGreat m = new MakeTheStringGreat();

        assert m.makeGood("leEeetcode").equals("leetcode");
        assert m.makeGood("abBAcC").equals("");
        assert m.makeGood("s").equals("s");

    }
}
