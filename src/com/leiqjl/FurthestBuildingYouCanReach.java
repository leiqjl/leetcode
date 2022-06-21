package com.leiqjl;

import java.util.PriorityQueue;

/**
 * 1642. Furthest Building You Can Reach - Medium
 * <p>
 * You are given an integer array heights representing the heights of buildings, some bricks, and some ladders.
 * <p>
 * You start your journey from building 0 and move to the next building by possibly using bricks or ladders.
 * <p>
 * While moving from building i to building i+1 (0-indexed),
 * <p>
 * - If the current building's height is greater than or equal to the next building's height, you do not need a ladder or bricks.
 * - If the current building's height is less than the next building's height, you can either use one ladder or (h[i+1] - h[i]) bricks.
 * <p>
 * Return the furthest building index (0-indexed) you can reach if you use the given ladders and bricks optimally.
 */
public class FurthestBuildingYouCanReach {

    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        for (int i = 0; i < heights.length - 1; i++) {
            int diff = heights[i + 1] - heights[i];
            if (diff <= 0) {
                continue;
            }
            if (diff <= bricks) {
                bricks -= diff;
                pq.offer(diff);
            } else if (ladders > 0) {
                if (!pq.isEmpty() && pq.peek() > diff) {
                    bricks += pq.poll();
                    bricks -= diff;
                    pq.offer(diff);
                }
                ladders--;
            } else {
                return i;
            }
        }
        return heights.length - 1;
    }

    public int furthestBuilding2(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < heights.length - 1; i++) {
            int diff = heights[i + 1] - heights[i];
            if (diff <= 0) {
                continue;
            }
            if (ladders > 0) {
                pq.offer(diff);
                ladders--;
            } else if (!pq.isEmpty() && diff > pq.peek()) {
                pq.offer(diff);
                bricks -= pq.poll();
            } else {
                bricks -= diff;
            }
            if (bricks < 0) {
                return i;
            }
        }
        return heights.length - 1;
    }


    public static void main(String[] args) {
        FurthestBuildingYouCanReach f = new FurthestBuildingYouCanReach();

        //Input: heights = [4,2,7,6,9,14,12], bricks = 5, ladders = 1
        //Output: 4
        int[] heights = new int[]{4, 2, 7, 6, 9, 14, 12};
        assert f.furthestBuilding(heights, 5, 1) == 4;
        //Input: heights = [4,12,2,7,3,18,20,3,19], bricks = 10, ladders = 2
        //Output: 7
        heights = new int[]{4, 12, 2, 7, 3, 18, 20, 3, 19};
        assert f.furthestBuilding(heights, 10, 2) == 7;
        //Input: heights = [14,3,19,3], bricks = 17, ladders = 0
        //Output: 3
        heights = new int[]{14, 3, 19, 3};
        assert f.furthestBuilding(heights, 17, 0) == 3;

    }
}
