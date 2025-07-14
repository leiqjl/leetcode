package com.leiqjl;

import java.util.Arrays;

/**
 * 2410. Maximum Matching of Players With Trainers - Medium
 */
public class MaximumMatchingOfPlayersWithTrainers {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int p = 0, t = 0;
        while (p < players.length && t < trainers.length) {
            if (players[p] <= trainers[t]) {
                p++;
                t++;
            } else {
                t++;
            }
        }
        return p;
    }
}
