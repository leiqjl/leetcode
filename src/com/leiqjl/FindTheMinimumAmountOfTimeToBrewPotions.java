package com.leiqjl;

/**
 * 3494. Find the Minimum Amount of Time to Brew Potions - Medium
 */
public class FindTheMinimumAmountOfTimeToBrewPotions {
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length;
        int m = mana.length;
        long[] end = new long[n + 1];
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                end[i + 1] = Math.max(end[i + 1], end[i]) + (long) skill[i] * mana[j];
            }
            for (int i = n - 1; i >= 0; i--) {
                end[i] = end[i + 1] - (long) skill[i] * mana[j];
            }
        }
        return end[n];
    }


    public static void main(String[] args) {
        FindTheMinimumAmountOfTimeToBrewPotions f = new FindTheMinimumAmountOfTimeToBrewPotions();
        assert f.minTime(new int[]{1, 5, 2, 4}, new int[]{5, 1, 4, 2}) == 110;
        assert f.minTime(new int[]{1, 1, 1}, new int[]{1, 1, 1}) == 5;
        assert f.minTime(new int[]{1, 2, 3, 4}, new int[]{1, 2}) == 21;
    }
}
