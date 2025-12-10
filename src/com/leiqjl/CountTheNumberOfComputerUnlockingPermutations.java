package com.leiqjl;

/**
 * 3577. Count the Number of Computer Unlocking Permutations - Medium
 */
public class CountTheNumberOfComputerUnlockingPermutations {
    public int countPermutations(int[] complexity) {
        int mod = 1_000_000_007;
        for (int i = 1; i < complexity.length; i++) {
            if (complexity[i] <= complexity[0]) {
                return 0;
            }
        }
        long ans = 1;
        for (int i = 1; i < complexity.length; i++) {
            ans = (ans * i) % mod;
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        CountTheNumberOfComputerUnlockingPermutations c = new CountTheNumberOfComputerUnlockingPermutations();
        assert c.countPermutations(new int[]{1, 2, 3}) == 1;
        assert c.countPermutations(new int[]{3, 3, 3, 4, 4, 4}) == 0;
    }
}
