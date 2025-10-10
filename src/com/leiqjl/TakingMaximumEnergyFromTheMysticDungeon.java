package com.leiqjl;

/**
 * 3147. Taking Maximum Energy From the Mystic Dungeon - Medium
 * In a mystic dungeon, n magicians are standing in a line. Each magician has an attribute that gives you energy. Some magicians can give you negative energy, which means taking energy from you.
 * <p>
 * You have been cursed in such a way that after absorbing energy from magician i, you will be instantly transported to magician (i + k). This process will be repeated until you reach the magician where (i + k) does not exist.
 * <p>
 * In other words, you will choose a starting point and then teleport with k jumps until you reach the end of the magicians' sequence, absorbing all the energy during the journey.
 * <p>
 * You are given an array energy and an integer k. Return the maximum possible energy you can gain.
 * <p>
 * Note that when you are reach a magician, you must take energy from them, whether it is negative or positive energy.
 */
public class TakingMaximumEnergyFromTheMysticDungeon {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int[] dp = new int[k];
        int max = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            int index = (n - 1 - i) % k;
            dp[index] += energy[i];
            max = Math.max(max, dp[index]);
        }
        return max;
    }

    public static void main(String[] args) {
        TakingMaximumEnergyFromTheMysticDungeon t = new TakingMaximumEnergyFromTheMysticDungeon();
        assert t.maximumEnergy(new int[]{5, 2, -10, -5, 1}, 3) == 3;
        assert t.maximumEnergy(new int[]{-2, -3, -1}, 2) == -1;
    }
}
