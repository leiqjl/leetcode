package com.leiqjl;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 853. Car Fleet - Medium
 * There are n cars at given miles away from the starting mile 0, traveling to reach the mile target.
 * <p>
 * You are given two integer array position and speed, both of length n, where position[i] is the starting mile of the ith car and speed[i] is the speed of the ith car in miles per hour.
 * <p>
 * A car cannot pass another car, but it can catch up and then travel next to it at the speed of the slower car.
 * <p>
 * A car fleet is a car or cars driving next to each other. The speed of the car fleet is the minimum speed of any car in the fleet.
 * <p>
 * If a car catches up to a car fleet at the mile target, it will still be considered as part of the car fleet.
 * <p>
 * Return the number of car fleets that will arrive at the destination.
 */
public class CarFleet {
    //Constraints:
    //
    //n == position.length == speed.length
    //1 <= n <= 10^5
    //0 < target <= 10^6
    //0 <= position[i] < target
    //All the values of position are unique.
    //0 < speed[i] <= 10^6

    //next speed < current speed
    //     miles > current miles
    public int carFleet(int target, int[] position, int[] speed) {
        // (target-pos)/speed
        double[][] posTime = new double[position.length][2];
        for (int i = 0; i < position.length; i++) {
            posTime[i][0] = position[i];
            posTime[i][1] = (double) (target - position[i]) / speed[i];
        }
        Arrays.sort(posTime, Comparator.comparingDouble(a -> a[0]));
        int count = 1;
        for (int i = position.length - 1; i > 0; i--) {
            if (posTime[i][1] < posTime[i - 1][1]) {
                count++;
            } else {
                posTime[i - 1][1] = posTime[i][1];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CarFleet c = new CarFleet();
        assert c.carFleet(12, new int[]{10, 8, 0, 5, 3}, new int[]{2, 4, 1, 1, 3}) == 3;
        assert c.carFleet(10, new int[]{3}, new int[]{3}) == 1;
        assert c.carFleet(100, new int[]{0, 2, 4}, new int[]{4, 2, 1}) == 1;
    }
}
