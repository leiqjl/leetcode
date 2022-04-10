package com.leiqjl;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 682. Baseball Game - Easy
 */
public class BaseballGame {
    //1 <= ops.length <= 1000
    //ops[i] is "C", "D", "+", or a string representing an integer in the range [-3 * 104, 3 * 104].
    //For operation "+", there will always be at least two previous scores on the record.
    //For operations "C" and "D", there will always be at least one previous score on the record.
    public int calPoints(String[] ops) {
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (String s : ops) {
            if (s.equals("C")) {
                int pop = stack.pop();
                res -= pop;
            } else if (s.equals("D")) {
                stack.push(stack.peek() * 2);
                res += stack.peek();
            } else if (s.equals("+")) {
                int pop = stack.pop();
                int tmp = pop + stack.peek();
                stack.push(pop);
                stack.push(tmp);
                res += stack.peek();
            } else {
                stack.push(Integer.parseInt(s));
                res += stack.peek();
            }
        }
        return res;
    }
}
