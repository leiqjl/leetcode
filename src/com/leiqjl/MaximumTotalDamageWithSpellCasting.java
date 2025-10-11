package com.leiqjl;

import java.util.Arrays;

/**
 * 3186. Maximum Total Damage With Spell Casting - Medium
 * A magician has various spells.
 * <p>
 * You are given an array power, where each element represents the damage of a spell. Multiple spells can have the same damage value.
 * <p>
 * It is a known fact that if a magician decides to cast a spell with a damage of power[i],
 * they cannot cast any spell with a damage of power[i] - 2, power[i] - 1, power[i] + 1, or power[i] + 2.
 * <p>
 * Each spell can be cast only once.
 * <p>
 * Return the maximum possible total damage that a magician can cast.
 */
public class MaximumTotalDamageWithSpellCasting {
    public long maximumTotalDamage(int[] power) {
        int n = power.length;
        Arrays.sort(power);
        long[] dp = new long[n];
        dp[0] = power[0];
        int index = 0;
        long max = 0;
        long answer = dp[0];
        for (int i = 1; i < n; i++) {
            if (power[i] == power[i - 1]) {
                dp[i] = dp[i - 1] + power[i];
            } else {
                while (index < i && power[index] < power[i] - 2) {
                    max = Math.max(max, dp[index]);
                    index++;
                }
                dp[i] = max + power[i];
            }
            answer = Math.max(answer, dp[i]);
        }
        return answer;
    }

    public static void main(String[] args) {
        MaximumTotalDamageWithSpellCasting m = new MaximumTotalDamageWithSpellCasting();
        assert m.maximumTotalDamage(new int[]{1, 1, 3, 4}) == 6;
        assert m.maximumTotalDamage(new int[]{7, 1, 6, 6}) == 13;
        assert m.maximumTotalDamage(new int[]{10}) == 10;
    }
}
