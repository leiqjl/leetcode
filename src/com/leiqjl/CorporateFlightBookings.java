package com.leiqjl;

/**
 * 1109. Corporate Flight Bookings - Medium
 * There are n flights that are labeled from 1 to n.
 * <p>
 * You are given an array of flight bookings bookings, where bookings[i] = [firsti, lasti, seatsi] represents a booking for flights firsti through lasti (inclusive) with seatsi seats reserved for each flight in the range.
 * <p>
 * Return an array answer of length n, where answer[i] is the total number of seats reserved for flight i.
 */
public class CorporateFlightBookings {

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n];
        for (int[] booking : bookings) {
            ans[booking[0] - 1] += booking[2];
            if (booking[1] < n) {
                ans[booking[1]] -= booking[2];
            }
        }
        for (int i = 1; i < n; i++) {
            ans[i] += ans[i - 1];
        }
        return ans;
    }
}
