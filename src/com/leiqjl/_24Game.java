package com.leiqjl;

import java.util.ArrayList;
import java.util.List;

/**
 * 679. 24 Game - Hard
 * You are given an integer array cards of length 4. You have four cards, each containing a number in the range [1, 9]. You should arrange the numbers on these cards in a mathematical expression using the operators ['+', '-', '*', '/'] and the parentheses '(' and ')' to get the value 24.
 * <p>
 * You are restricted with the following rules:
 * <p>
 * ·The division operator '/' represents real division, not integer division.
 * ·For example, 4 / (1 - 2 / 3) = 4 / (1 / 3) = 12.
 * ·Every operation done is between two numbers. In particular, we cannot use '-' as a unary operator.
 * ·For example, if cards = [1, 1, 1, 1], the expression "-1 - 1 - 1 - 1" is not allowed.
 * ·You cannot concatenate numbers together
 * ·For example, if cards = [1, 2, 1, 2], the expression "12 + 12" is not valid.
 * Return true if you can get such expression that evaluates to 24, and false otherwise.
 */
public class _24Game {
    final double EPS = 1e-6;

    public boolean judgePoint24(int[] cards) {
        List<Double> list = new ArrayList<>();
        for (int card : cards) {
            list.add((double) card);
        }
        return dfs(list);
    }

    private boolean dfs(List<Double> list) {
        if (list.size() == 1) {
            return Math.abs(list.get(0) - 24.0) < EPS;
        }
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                List<Double> newList = new ArrayList<>();
                for (int k = 0; k < list.size(); k++) {
                    if (k != i && k != j) {
                        newList.add(list.get(k));
                    }
                }
                List<Double> computeResult = compute(list.get(i), list.get(j));
                for (double num : computeResult) {
                    newList.add(num);
                    if (dfs(newList)) {
                        return true;
                    }
                    newList.remove(newList.size() - 1);
                }
            }
        }
        return false;
    }

    private List<Double> compute(double x, double y) {
        List<Double> result = new ArrayList<>();
        result.add(x + y);
        result.add(x - y);
        result.add(y - x);
        result.add(x * y);
        if (Math.abs(y) > EPS) {
            result.add(x / y);
        }
        if (Math.abs(x) > EPS) {
            result.add(y / x);
        }
        return result;
    }

    public static void main(String[] args) {
        _24Game t = new _24Game();
        //Input: cards = [4,1,8,7]
        //Output: true
        assert t.judgePoint24(new int[]{4, 1, 8, 7});
        //Input: cards = [1,2,1,2]
        //Output: false
        assert !t.judgePoint24(new int[]{1, 2, 1, 2});
        assert t.judgePoint24(new int[]{1, 7, 4, 5});
        assert !t.judgePoint24(new int[]{3, 4, 6, 7});
    }
}
