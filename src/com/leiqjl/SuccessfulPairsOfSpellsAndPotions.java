package com.leiqjl;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 2300. Successful Pairs of Spells and Potions - Medium
 */
public class SuccessfulPairsOfSpellsAndPotions {
    public int[] successfulPairs1(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] result = new int[spells.length];
        for (int i = 0; i < spells.length; i++) {

            int l = 0, r = potions.length;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if ((long) potions[mid] * spells[i] < success) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            result[i] = potions.length - l;
        }
        return result;
    }

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int m = spells.length;
        int n = potions.length;
        int[] result = new int[m];
        int[][] spellsIdxPairs = new int[m][2];

        for (int i = 0; i < m; i++) {
            spellsIdxPairs[i][0] = spells[i];
            spellsIdxPairs[i][1] = i;
        }
        Arrays.sort(spellsIdxPairs, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(potions);
        int end = n - 1;
        for (int[] pair : spellsIdxPairs) {
            while (end >= 0 && (long) pair[0] * potions[end] >= success) {
                end--;
            }
            result[pair[1]] = n - 1 - end;
        }
        return result;
    }

    public static void main(String[] args) {
        SuccessfulPairsOfSpellsAndPotions s = new SuccessfulPairsOfSpellsAndPotions();
        assert "[4, 0, 3]".equals(Arrays.toString(s.successfulPairs(new int[]{5, 1, 3}, new int[]{1, 2, 3, 4, 5}, 7)));
        assert "[2, 0, 2]".equals(Arrays.toString(s.successfulPairs(new int[]{3, 1, 2}, new int[]{8, 5, 8}, 16)));
    }
}
