package com.leiqjl;

import java.util.ArrayList;
import java.util.List;

/**
 * 386. Lexicographical Numbers - Medium
 * Given an integer n, return all the numbers in the range [1, n] sorted in lexicographical order.
 * <p>
 * You must write an algorithm that runs in O(n) time and uses O(1) extra space.
 */
public class LexicographicalNumbers {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            dfs(i, n, list);
        }
        return list;
    }

    private void dfs(int num, int n, List<Integer> list) {
        if (num > n) {
            return;
        }
        list.add(num);
        num *= 10;
        for (int i = num; i <= num + 9; i++) {
            dfs(i, n, list);
        }
    }

    public static void main(String[] args) {
        LexicographicalNumbers l = new LexicographicalNumbers();
        System.out.println(l.lexicalOrder(13));
//        assert Arrays.equals(, new int[]{1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9});
    }
}
