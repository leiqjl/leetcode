package com.leiqjl;

import java.util.Arrays;

/**
 * 923. 3Sum With Multiplicity - Medium
 * Given an integer array arr, and an integer target,
 * return the number of tuples i, j, k such that i < j < k and arr[i] + arr[j] + arr[k] == target.
 * <p>
 * As the answer can be very large, return it modulo 10^9 + 7.
 */
public class _3SumWithMultiplicity {

    // time O(N^2) space O(1)
    public int threeSumMulti(int[] arr, int target) {
        Arrays.sort(arr);
        int mod = 1000000007;
        int count = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            if (arr[i] > target) {
                continue;
            }
            int l = i + 1;
            int r = arr.length - 1;
            int t = target - arr[i];
            while (l < r) {
                int sum = arr[l] + arr[r];
                if (sum > t) {
                    r--;
                } else if (sum < t) {
                    l++;
                } else if (arr[l] != arr[r]) {
                    int lc = 1;
                    int rc = 1;
                    while (l + 1 < r && arr[l] == arr[l + 1]) {
                        l++;
                        lc++;
                    }
                    while (l < r - 1 && arr[r - 1] == arr[r]) {
                        r--;
                        rc++;
                    }
                    l++;
                    r--;
                    count = (count + lc * rc) % mod;
                } else {
                    count = (count + (r - l + 1) * (r - l) / 2) % mod;
                    break;
                }
            }
        }
        return count;
    }

    // time O(N + 101^2) space O(101)
    public int threeSumMulti1(int[] arr, int target) {
        long[] cnt = new long[101];
        long res = 0;
        for (int a : arr) {
            cnt[a]++;
        }
        for (int i = 0; i < 101; i++) {
            for (int j = i; j < 101; j++) {
                int k = target - i - j;
                if (k > 100 || k < 0) {
                    continue;
                }

                if (i == j && j == k) {
                    res = res + cnt[i] * (cnt[i] - 1) * (cnt[i] - 2) / 6;
                } else if (i == j && j != k) {
                    res = res + cnt[i] * (cnt[i] - 1) / 2 * cnt[k];
                } else if (i < k && j < k) {
                    res = res + cnt[i] * cnt[j] * cnt[k];
                }
            }
        }
        return (int) (res % 1000000007);
    }

    public static void main(String[] args) {
        _3SumWithMultiplicity t = new _3SumWithMultiplicity();
        //Input: arr = [1,1,2,2,3,3,4,4,5,5], target = 8
        //Output: 20
        int[] arr = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
        System.out.println(t.threeSumMulti(arr, 8));
    }
}
