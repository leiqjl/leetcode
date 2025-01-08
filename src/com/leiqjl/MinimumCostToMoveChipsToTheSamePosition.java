package com.leiqjl;

/**
 * 1217. Minimum Cost to Move Chips to The Same Position - Easy
 * We have n chips, where the position of the ith chip is position[i].
 * <p>
 * We need to move all the chips to the same position. In one step, we can change the position of the ith chip from position[i] to:
 * <p>
 * position[i] + 2 or position[i] - 2 with cost = 0.
 * position[i] + 1 or position[i] - 1 with cost = 1.
 * Return the minimum cost needed to move all the chips to the same position.
 */
public class MinimumCostToMoveChipsToTheSamePosition {
    public int minCostToMoveChips(int[] position) {
        int odds = 0, evens = 0;
        for (int pos : position) {
            if ((pos & 1) == 0) {
                evens++;
            } else {
                odds++;
            }
        }
        return Math.min(odds, evens);
    }

    public static void main(String[] args) {
        MinimumCostToMoveChipsToTheSamePosition m = new MinimumCostToMoveChipsToTheSamePosition();
        assert m.minCostToMoveChips(new int[]{1, 2, 3}) == 1;
        assert m.minCostToMoveChips(new int[]{2, 2, 2, 3, 3}) == 2;
    }
}
