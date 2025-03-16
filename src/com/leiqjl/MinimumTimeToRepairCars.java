package com.leiqjl;

/**
 * 2594. Minimum Time to Repair Cars - Medium
 * You are given an integer array ranks representing the ranks of some mechanics. ranksi is the rank of the ith mechanic. A mechanic with a rank r can repair n cars in r * n^2 minutes.
 * <p>
 * You are also given an integer cars representing the total number of cars waiting in the garage to be repaired.
 * <p>
 * Return the minimum time taken to repair all the cars.
 * <p>
 * Note: All the mechanics can repair the cars simultaneously.
 */
public class MinimumTimeToRepairCars {

    //1 <= ranks.length <= 10^5
    //1 <= ranks[i] <= 100
    //1 <= cars <= 10^6
    public long repairCars(int[] ranks, int cars) {
        long right = (long) ranks[0] * cars * cars;
        long left = 1;
        while (left < right) {
            long mid = (left + right) / 2;
            if (canRepair(ranks, cars, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canRepair(int[] ranks, int cars, long time) {
        long count = 0;
        for (int rank : ranks) {
            count += (long) (Math.sqrt((double) time / rank));
        }
        return count >= cars;
    }

    public static void main(String[] args) {
        MinimumTimeToRepairCars m = new MinimumTimeToRepairCars();
        assert m.repairCars(new int[]{4, 2, 3, 1}, 10) == 16;
        assert m.repairCars(new int[]{5, 1, 8}, 6) == 16;
    }
}
