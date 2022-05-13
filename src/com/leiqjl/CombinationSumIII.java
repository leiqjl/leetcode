package com.leiqjl;

import java.util.ArrayList;
import java.util.List;

/**
 * 216. Combination Sum III - Medium
 * <p>
 * Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
 * - Only numbers 1 through 9 are used.
 * - Each number is used at most once.
 * Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.
 */
public class CombinationSumIII {


    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        traverse(k, n, 1, new ArrayList<>(), result);
        return result;
    }

    private void traverse(int k, int n, int s, List<Integer> list, List<List<Integer>> result) {
        if (list.size() > k) {
            return;
        }
        if (n == 0 && list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = s; i <= 9; i++) {
            list.add(i);
            traverse(k, n-i, i+1, list, result);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSumIII c = new CombinationSumIII();
        //Input: k = 3, n = 7
        //Output: [[1,2,4]]
        assert "[[1, 2, 4]]".equals(c.combinationSum3(3, 7).toString());
        //Input: k = 3, n = 9
        //Output: [[1,2,6],[1,3,5],[2,3,4]]
        assert "[[1, 2, 6], [1, 3, 5], [2, 3, 4]]".equals(c.combinationSum3(3, 9).toString());
    }
}
