package com.leiqjl;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1298. Maximum Candies You Can Get from Boxes - Hard
 */
public class MaximumCandiesYouCanGetFromBoxes {

    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int max = 0;
        Deque<Integer> curQueue = new ArrayDeque<>();
        Deque<Integer> nextQueue = new ArrayDeque<>();
        for (int initialBox : initialBoxes) {
            if (status[initialBox] == 1) {
                curQueue.offer(initialBox);
            } else {
                nextQueue.offer(initialBox);
            }
        }
        while (!curQueue.isEmpty()) {
            while (!curQueue.isEmpty()) {
                int cur = curQueue.poll();
                max += candies[cur];
                for (int i : keys[cur]) {
                    status[i] = 1;
                }

                for (int i : containedBoxes[cur]) {
                    if (status[i] == 1) {
                        curQueue.offer(i);
                    } else {
                        nextQueue.offer(i);
                    }
                }
            }
            if (!nextQueue.isEmpty()) {
                int size = nextQueue.size();
                while (size-- > 0) {
                    int first = nextQueue.removeFirst();
                    if (status[first] == 1) {
                        curQueue.offer(first);
                    } else {
                        nextQueue.addLast(first);
                    }
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        MaximumCandiesYouCanGetFromBoxes m = new MaximumCandiesYouCanGetFromBoxes();
        //Input: status = [1,0,1,0], candies = [7,5,4,100], keys = [[],[],[1],[]], containedBoxes = [[1,2],[3],[],[]], initialBoxes = [0]
        //Output: 16
        assert m.maxCandies(new int[]{1, 0, 1, 0}, new int[]{7, 5, 4, 100}, new int[][]{{}, {}, {1}, {}}, new int[][]{{1, 2}, {3}, {}, {}}, new int[]{0}) == 16;
        //Input: status = [1,0,0,0,0,0], candies = [1,1,1,1,1,1], keys = [[1,2,3,4,5],[],[],[],[],[]], containedBoxes = [[1,2,3,4,5],[],[],[],[],[]], initialBoxes = [0]
        //Output: 6
        assert m.maxCandies(new int[]{1, 0, 0, 0, 0, 0}, new int[]{1, 1, 1, 1, 1, 1}, new int[][]{{1, 2, 3, 4, 5}, {}, {}, {}, {}, {}}, new int[][]{{1, 2, 3, 4, 5}, {}, {}, {}, {}, {}}, new int[]{0}) == 6;
    }
}
