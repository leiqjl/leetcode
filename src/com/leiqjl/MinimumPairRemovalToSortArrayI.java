package com.leiqjl;

import java.util.ArrayList;
import java.util.List;

/**
 * 3507. Minimum Pair Removal to Sort Array I - Easy
 */
public class MinimumPairRemovalToSortArrayI {
    public int minimumPairRemoval(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        int count = 0;
        while (list.size() > 1) {
            int index = -1;
            boolean ascending = true;
            int minSum = Integer.MAX_VALUE;
            for (int i = 0; i < list.size() - 1; i++) {
                int sum = list.get(i) + list.get(i + 1);
                if (list.get(i) > list.get(i + 1)) {
                    ascending = false;
                }
                if (sum < minSum) {
                    minSum = sum;
                    index = i;
                }
            }
            if (ascending) {
                break;
            }
            list.set(index, minSum);
            list.remove(index + 1);
            count++;
        }
        return count;
    }
}
