package com.leiqjl;

/**
 * 2528. Maximize the Minimum Powered City - Hard
 * You are given a 0-indexed integer array stations of length n, where stations[i] represents the number of power stations in the ith city.
 * <p>
 * Each power station can provide power to every city in a fixed range. In other words, if the range is denoted by r, then a power station at city i can provide power to all cities j such that |i - j| <= r and 0 <= i, j <= n - 1.
 * <p>
 * ·Note that |x| denotes absolute value. For example, |7 - 5| = 2 and |3 - 10| = 7.
 * The power of a city is the total number of power stations it is being provided power from.
 * <p>
 * The government has sanctioned building k more power stations, each of which can be built in any city, and have the same range as the pre-existing ones.
 * <p>
 * Given the two integers r and k, return the maximum possible minimum power of a city, if the additional power stations are built optimally.
 * <p>
 * Note that you can build the k power stations in multiple cities.
 */
public class MaximizeTheMinimumPoweredCity {
    public long maxPower(int[] stations, int r, int k) {
        int n = stations.length;
        long[] diff = new long[n + 1];

        for (int i = 0; i < n; i++) {
            int left = Math.max(0, i - r);
            int right = Math.min(n, i + r + 1);
            diff[left] += stations[i];
            diff[right] -= stations[i];
        }
        long min = Long.MAX_VALUE;
        long cur = 0;
        for (int i = 0; i < n; i++) {
            long val = diff[i];
            cur += val;
            min = Math.min(min, cur);
        }
        long left = min;
        long right = min + k;
        long answer = 0;
        while (left <= right) {
            long mid = (left + right + 1) / 2;
            if (check(diff, mid, r, k)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }

    private boolean check(long[] diffOrigin, long mid, int r, long k) {
        int n = diffOrigin.length - 1;
        long[] diff = diffOrigin.clone();
        long cur = 0;
        for (int i = 0; i < n; i++) {
            cur += diff[i];
            if (cur < mid) {
                long need = mid - cur;
                if (need > k) {
                    return false;
                }
                k -= need;
                diff[Math.min(n, i + r * 2 + 1)] -= need;
                cur += need;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MaximizeTheMinimumPoweredCity m = new MaximizeTheMinimumPoweredCity();
        //Input: stations = [1,2,4,5,0], r = 1, k = 2
        //Output: 5
        assert m.maxPower(new int[]{1, 2, 4, 5, 0}, 1, 2) == 5;
        //Input: stations = [4,4,4,4], r = 0, k = 3
        //Output: 4
        assert m.maxPower(new int[]{4, 4, 4, 4}, 0, 3) == 4;
    }
}
