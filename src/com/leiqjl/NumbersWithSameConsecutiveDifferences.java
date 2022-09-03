package com.leiqjl;

import java.util.ArrayList;
import java.util.List;

/**
 * 967. Numbers With Same Consecutive Differences - Medium
 */
public class NumbersWithSameConsecutiveDifferences {

    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            dfs(i, i, n - 1, k, list);
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private void dfs(int curVal, int s, int n, int k, List<Integer> list) {
        if (s < 0 || s > 9) {
            return;
        }
        if (n == 0) {
            list.add(curVal);
            return;
        }
        curVal *= 10;
        dfs(curVal +(s + k), s + k, n - 1, k, list);
        if (k != 0) {
            dfs(curVal + (s - k), s - k, n - 1, k, list);
        }
    }
}
