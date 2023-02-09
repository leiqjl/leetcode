package com.leiqjl;

import java.util.HashMap;
import java.util.Map;

/**
 * 904. Fruit Into Baskets - Medium
 */
public class FruitIntoBaskets {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int l = 0, r;
        int max = 0;
        for (r = 0; r < fruits.length; r++) {
            countMap.put(fruits[r], countMap.getOrDefault(fruits[r], 0) + 1);
            while (countMap.size() > 2) {
                int f = fruits[l];
                int count = countMap.get(f) - 1;
                if (count == 0) {
                    countMap.remove(f);
                } else {
                    countMap.put(f, count);
                }
                l++;
            }
            max = Math.max(max, r - l + 1);
        }

        return max;
    }
}
