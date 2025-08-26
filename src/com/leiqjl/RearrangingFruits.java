package com.leiqjl;

import java.util.*;

/**
 * 2561. Rearranging Fruits - Hard
 * You have two fruit baskets containing n fruits each. You are given two 0-indexed integer arrays basket1 and basket2 representing the cost of fruit in each basket. You want to make both baskets equal. To do so, you can use the following operation as many times as you want:
 *
 * ·Choose two indices i and j, and swap the ith fruit of basket1 with the jth fruit of basket2.
 * ·The cost of the swap is min(basket1[i], basket2[j]).
 * Two baskets are considered equal if sorting them according to the fruit cost makes them exactly the same baskets.
 *
 * Return the minimum cost to make both the baskets equal or -1 if impossible.
 */
public class RearrangingFruits {

    public long minCost(int[] basket1, int[] basket2) {
        Map<Integer, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < basket1.length; i++) {
            map.put(basket1[i], map.getOrDefault(basket1[i], 0) + 1);
            min = Math.min(min, basket1[i]);
            map.put(basket2[i], map.getOrDefault(basket2[i], 0) - 1);
            min = Math.min(min, basket2[i]);
        }
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int fruit = entry.getKey();
            int count = entry.getValue();
            count = Math.abs(count);
            if ((count & 1) == 1) {
                return -1;
            }
            count /= 2;
            for (int i = 0; i < count; i++) {
                list.add(fruit);
            }
        }
        Collections.sort(list);
        long result = 0;
        for (int i = 0; i < list.size() / 2; i++) {
            result += Math.min(min * 2, list.get(i));
        }
        return result;
    }

    public static void main(String[] args) {
        RearrangingFruits r = new RearrangingFruits();
        //Input: basket1 = [4,2,2,2], basket2 = [1,4,1,2]
        //Output: 1
        assert r.minCost(new int[]{4, 2, 2, 2}, new int[]{1, 4, 1, 2}) == 1;
        //Input: basket1 = [2,3,4,1], basket2 = [3,2,5,1]
        //Output: -1
        assert r.minCost(new int[]{2, 3, 4, 1}, new int[]{3, 2, 5, 1}) == -1;
    }
}
