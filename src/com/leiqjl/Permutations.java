package com.leiqjl;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. Permutations - Medium
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>(nums.length);
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        dfs(nums, visited, list, result);
        return result;
    }

    private void dfs(int[] nums, boolean[] visited, List<Integer> list, List<List<Integer>> result) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            list.add(nums[i]);
            visited[i] = true;
            dfs(nums, visited, list, result);
            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
