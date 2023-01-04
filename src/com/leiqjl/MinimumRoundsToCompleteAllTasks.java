package com.leiqjl;

import java.util.HashMap;

/**
 * 2244. Minimum Rounds to Complete All Tasks - Medium
 */
public class MinimumRoundsToCompleteAllTasks {
    public int minimumRounds(int[] tasks) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int task : tasks) {
            hashMap.put(task, hashMap.getOrDefault(task, 0) + 1);
        }
        int result = 0;
        for (int count : hashMap.values()) {
            if (count == 1) {
                return -1;
            }
            result = result + (count + 2) / 3;
        }
        return result;
    }
}
