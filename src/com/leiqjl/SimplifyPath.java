package com.leiqjl;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 71. Simplify Path - Medium
 */
public class SimplifyPath {

    public String simplifyPath(String path) {
        String[] str = path.split("/");
        Deque<String> deque = new ArrayDeque<>();
        for (String s : str) {
            if (!deque.isEmpty() && s.equals("..")) {
                deque.removeLast();
            } else if (!s.equals(".") && !s.equals("") && !s.equals("..")) {
                deque.addLast(s);
            }
        }
        return "/" + String.join("/", deque);
    }
}
