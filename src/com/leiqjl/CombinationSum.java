package com.leiqjl;

import java.util.ArrayList;
import java.util.List;

/**
 * 39. Combination Sum - Medium
 */
public class CombinationSum {

    //1 <= candidates.length <= 30
    //1 <= candidates[i] <= 200
    //All elements of candidates are distinct.
    //1 <= target <= 500
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(0, candidates, target, new ArrayList<>(), result);
        return result;
    }

    private void dfs(int s, int[] candidates, int target, List<Integer> list, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        if (target < 0 || s >= candidates.length) {
            return;
        }
        for (int i = s; i < candidates.length; i++) {
            list.add(candidates[i]);
            dfs(i, candidates, target - candidates[i], list, result);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum c = new CombinationSum();
        //Input: candidates = [2,3,6,7], target = 7
        //Output: [[2,2,3],[7]]
        int[] candidates = {2, 3, 6, 7};
        assert c.combinationSum(candidates, 7).toString().equals("[[2, 2, 3], [7]]");
        //Input: candidates = [2,3,5], target = 8
        //Output: [[2,2,2,2],[2,3,3],[3,5]]
        int[] candidates1 = {2, 3, 5};
        assert c.combinationSum(candidates1, 8).toString().equals("[[2, 2, 2, 2], [2, 3, 3], [3, 5]]");
        //Input: candidates = [2], target = 1
        //Output: []
        int[] candidates2 = {2};
        assert c.combinationSum(candidates2, 1).toString().equals("[]");
    }
}
