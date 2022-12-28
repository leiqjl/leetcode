package com.leiqjl;

/**
 * 1011. Capacity To Ship Packages Within D Days - Medium
 */
public class CapacityToShipPackagesWithinDDays {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0, right = 0;
        for (int w : weights) {
            left = Math.max(w, left);
            right += w;
        }
        while (left < right) {
            int mid = (left + right) / 2;
            int day = 1, temp = 0;
            for (int w : weights) {
                if (temp + w > mid) {
                    temp = 0;
                    day++;
                }
                temp += w;
            }
            if (day > days) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
