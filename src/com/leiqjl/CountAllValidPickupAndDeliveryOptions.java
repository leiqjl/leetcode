package com.leiqjl;

/**
 * 1359. Count All Valid Pickup and Delivery Options - Hard
 * <p>
 * Given n orders, each order consist in pickup and delivery services.
 * <p>
 * Count all valid pickup/delivery possible sequences such that delivery(i) is always after of pickup(i).
 * <p>
 * Since the answer may be too large, return it modulo 10^9 + 7.
 */
public class CountAllValidPickupAndDeliveryOptions {

    // (2n-1) * (2n-1 + 1)/2
    public int countOrders(int n) {
        long result = 1, mod = (long) 1e9 + 7;
        for (int i = 1; i <= n; i++) {
            result = (result * (2L * i - 1) * i) % mod;
        }
        return (int) result;
    }

}
