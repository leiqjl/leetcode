package com.leiqjl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2225. Find Players With Zero or One Losses - Medium
 */
public class FindPlayersWithZeroOrOneLosses {
    //1 <= matches.length <= 10^5
    //matches[i].length == 2
    //1 <= winneri, loseri <= 10^5
    //winneri != loseri
    //All matches[i] are unique.
    public List<List<Integer>> findWinners(int[][] matches) {
        int[] count = new int[100001];
        Arrays.fill(count, -1);
        for (int[] match : matches) {
            if (count[match[0]] == -1) {
                count[match[0]] = 0;
            }
            if (count[match[1]] == -1) {
                count[match[1]] = 1;
            } else {
                count[match[1]]++;
            }
        }
        List<Integer> zeroLossList = new ArrayList<>();
        List<Integer> oneLossList = new ArrayList<>();
        for (int i = 1; i <= 100000; i++) {
            if (count[i] == 0) {
                zeroLossList.add(i);
            } else if (count[i] == 1) {
                oneLossList.add(i);
            }
        }
        return List.of(zeroLossList, oneLossList);
    }
}
