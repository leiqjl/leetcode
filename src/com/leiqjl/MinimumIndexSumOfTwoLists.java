package com.leiqjl;

import java.util.*;

/**
 * 599. Minimum Index Sum of Two Lists
 * <p>
 * Suppose Andy and Doris want to choose a restaurant for dinner,
 * and they both have a list of favorite restaurants represented by strings.
 * <p>
 * You need to help them find out their common interest with the least list index sum.
 * If there is a choice tie between answers, output all of them with no order requirement.
 * You could assume there always exists an answer.
 */
public class MinimumIndexSumOfTwoLists {

    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>(list1.length);
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        List<String> result = new LinkedList<>();
        int minSum = Integer.MAX_VALUE;
        int sum;
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                sum = i + map.get(list2[i]);
                if (sum < minSum) {
                    result.clear();
                    result.add(list2[i]);
                    minSum = sum;
                } else if (sum == minSum) {
                    result.add(list2[i]);
                }
            }
        }
        return result.toArray(new String[0]);
    }
}
