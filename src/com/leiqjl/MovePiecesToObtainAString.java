package com.leiqjl;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 2337. Move Pieces to Obtain a String - Medium
 * You are given two strings start and target, both of length n. Each string consists only of the characters 'L', 'R', and '_' where:
 * <p>
 * - The characters 'L' and 'R' represent pieces, where a piece 'L' can move to the left only if there is a blank space directly to its left, and a piece 'R' can move to the right only if there is a blank space directly to its right.
 * - The character '_' represents a blank space that can be occupied by any of the 'L' or 'R' pieces.
 * Return true if it is possible to obtain the string target by moving the pieces of the string start any number of times. Otherwise, return false.
 */
public class MovePiecesToObtainAString {

    // T:O(n) S:O(1) two pointers
    public boolean canChange(String start, String target) {
        int n = start.length();
        int i = 0, j = 0;
        while (i <= n && j <= n) {
            while (i < n && start.charAt(i) == '_') {
                i++;
            }
            while (j < n && target.charAt(j) == '_') {
                j++;
            }
            if (i == n || j == n) {
                return i == n && j == n;
            }
            if (start.charAt(i) != target.charAt(j)) {
                return false;
            }
            if (start.charAt(i) == 'L' && i < j) {
                return false;
            } else if (start.charAt(i) == 'R' && i > j) {
                return false;
            }
            i++;
            j++;
        }
        return true;
    }

    // T:O(n) S:O(n) stack
    public boolean canChange1(String start, String target) {
        int n = start.length();
        Deque<Character> deque = new ArrayDeque<>();
        int j = 0;
        for (int i = 0; i < n; i++) {
            char c = target.charAt(i);
            while (j < n && (deque.isEmpty() || deque.peek() != c)) {
                deque.push(start.charAt(j++));
            }
            Character pop = deque.pop();
            if (c != pop) {
                return false;
            }
            if (c == '_' && !deque.isEmpty() && deque.peek() == 'L') {
                return false;
            }
            if (c == 'L' && !deque.isEmpty() && deque.peek() == 'R') {
                return false;
            }
            if (c == 'R' && !deque.isEmpty() && deque.peek() != 'R') {
                return false;
            }
        }
        return deque.isEmpty();
    }

    public static void main(String[] args) {
        MovePiecesToObtainAString m = new MovePiecesToObtainAString();
        assert m.canChange("_L__R__R_", "L______RR");
        assert !m.canChange("R_L_", "__LR");
        assert !m.canChange("_R", "R_");
        assert !m.canChange("_LL__R__R_", "L___L___RR");
    }
}