package com.leiqjl;

import java.util.Arrays;

/**
 * 473. Matchsticks to Square - Medium
 */
public class MatchsticksToSquare {
    //1 <= matchsticks.length <= 15
    //1 <= matchsticks[i] <= 10^8
    //todo
    public boolean makesquare(int[] matchsticks) {
        if (matchsticks == null || matchsticks.length < 4) {
            return false;
        }
        int sum = 0;
        for (int m : matchsticks) {
            sum += m;
        }
        int len = sum / 4;
        if (len * 4 != sum) {
            return false;
        }


        Arrays.sort(matchsticks);
        return dfs(matchsticks.length - 1, new int[4], matchsticks, len);
    }

    private boolean dfs(int index, int[] sums, int[] matchsticks, int len) {
        if (index < 0) {
            if (sums[0] == len && sums[1] == len && sums[2] == len) {
                return true;
            }
            return false;
        }

        for (int i = 0; i < 4; i++) {
            if (sums[i] + matchsticks[index] <= len) {
                sums[i] += matchsticks[index];
                if (dfs(index - 1, sums, matchsticks, len)) {
                    return true;
                }
                sums[i] -= matchsticks[index];
            }
        }
        return false;
    }
}
