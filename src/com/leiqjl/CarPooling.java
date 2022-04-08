package com.leiqjl;

/**
 * 1094. Car Pooling - Medium
 */
public class CarPooling {

    //1 <= trips.length <= 1000
    //trips[i].length == 3
    //1 <= numPassengersi <= 100
    //0 <= fromi < toi <= 1000
    //1 <= capacity <= 105
    // O(N)
    public boolean carPooling(int[][] trips, int capacity) {
        int[] diff = new int[1001];
        for (int i = 0; i < trips.length; i++) {
            int numPassengers = trips[i][0];
            int from = trips[i][1];
            int to = trips[i][2];
            diff[from] += numPassengers;
            diff[to] -= numPassengers;
        }
        int num = 0;
        for (int i = 0; i < 1001; i++) {
            num += diff[i];
            if (num > capacity) {
                return false;
            }
        }
        return true;
    }

    public boolean carPooling1(int[][] trips, int capacity) {

        return false;
    }
}
