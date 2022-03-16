package com.leiqjl;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 946. Validate Stack Sequences - Medium
 *
 * Given two integer arrays pushed and popped each with distinct values,
 * return true if this could have been the result of a sequence of push and pop operations on an initially empty stack, or false otherwise.
 */
public class ValidateStackSequences {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = pushed.length;
        Deque<Integer> stack = new ArrayDeque<>(n);
        int i = 0;
        for (int p : pushed) {
            stack.push(p);
            while (!stack.isEmpty() && popped[i] == stack.peek()) {
                stack.pop();
                i++;
            }
        }
        return stack.size() == 0;
    }

    public static void main(String[] args) {
        ValidateStackSequences v = new ValidateStackSequences();
        //Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
        //Output: true
        //Explanation: We might do the following sequence:
        //push(1), push(2), push(3), push(4),
        //pop() -> 4,
        //push(5),
        //pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
        int[] pushed = {1,2,3,4,5};
        int[] popped = {4,5,3,2,1};
        assert v.validateStackSequences(pushed, popped);
        //Input: pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
        //Output: false
        //Explanation: 1 cannot be popped before 2.
        int[] pushed1 = {1,2,3,4,5};
        int[] popped1 = {4,3,5,1,2};
        assert !v.validateStackSequences(pushed1, popped1);
    }
}
