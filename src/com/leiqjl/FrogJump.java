package com.leiqjl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 403. Frog Jump - Hard
 * A frog is crossing a river. The river is divided into some number of units, and at each unit, there may or may not exist a stone. The frog can jump on a stone, but it must not jump into the water.
 * <p>
 * Given a list of stones positions (in units) in sorted ascending order, determine if the frog can cross the river by landing on the last stone. Initially, the frog is on the first stone and assumes the first jump must be 1 unit.
 * <p>
 * If the frog's last jump was k units, its next jump must be either k - 1, k, or k + 1 units. The frog can only jump in the forward direction.
 */
public class FrogJump {
    //Constraints:
    //
    //2 <= stones.length <= 2000
    //0 <= stones[i] <= 2^31 - 1
    //stones[0] == 0
    //stones is sorted in a strictly increasing order.
    public boolean canCross(int[] stones) {
        if (stones[1] != 1) {
            return false;
        }
        int n = stones.length;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            map.put(stones[i], new HashSet<>());
        }
        map.get(0).add(1);
        for (int i = 0; i < n - 1; i++) {
            int stone = stones[i];
            int minStep = stones[i + 1] - stones[i];
            for (int step : map.get(stone)) {
                if (step < minStep) {
                    continue;
                }
                int next = stone + step;
                if (next == stones[n - 1]) {
                    return true;
                }
                Set<Integer> steps = map.get(next);
                if (steps != null) {
                    if (step > 1) {
                        steps.add(step - 1);
                    }
                    steps.add(step);
                    steps.add(step + 1);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        FrogJump f = new FrogJump();
        assert f.canCross(new int[]{0, 1, 3, 5, 6, 8, 12, 17});
        assert !f.canCross(new int[]{0, 1, 2, 3, 4, 8, 9, 11});
        assert !f.canCross(new int[]{0, 1, 2, 3, 4, 5, 6, 12});
        assert f.canCross(new int[]{0, 1});
    }
}
