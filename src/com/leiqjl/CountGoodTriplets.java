package com.leiqjl;

/**
 * 1534. Count Good Triplets - Easy
 * Given an array of integers arr, and three integers a, b and c. You need to find the number of good triplets.
 * <p>
 * A triplet (arr[i], arr[j], arr[k]) is good if the following conditions are true:
 * <p>
 * ·0 <= i < j < k < arr.length
 * ·|arr[i] - arr[j]| <= a
 * ·|arr[j] - arr[k]| <= b
 * ·|arr[i] - arr[k]| <= c
 * Where |x| denotes the absolute value of x.
 * <p>
 * Return the number of good triplets.
 */
public class CountGoodTriplets {

    //Constraints:
    //
    //3 <= arr.length <= 100
    //0 <= arr[i] <= 1000
    //0 <= a, b, c <= 1000

    // 0 <= i < j < k < arr.length
    // |arr[i] - arr[j]| <= a
    // |arr[j] - arr[k]| <= b
    // |arr[i] - arr[k]| <= c
    //  [arr[j]-a,arr[j]+a]
    //  [arr[k]-c,arr[k]+c]
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int n = arr.length;
        int[] freq = new int[1001];
        int[] suffixSum = new int[1001];
        freq[arr[0]] = 1;
        for (int i = n - 1; i > 1; i--) {
            suffixSum[arr[i]]++;
        }
        for (int i = 1; i <= 1000; i++) {
            suffixSum[i] = suffixSum[i - 1] + suffixSum[i];
        }
        int count = 0;
        for (int j = 1; j < n - 1; j++) {
            int mid = arr[j];
            int li = Math.max(0, mid - a);
            int ri = Math.min(1000, mid + a);
            int lk = Math.max(0, mid - b);
            int rk = Math.min(1000, mid + b);
            for (int iVal = li; iVal <= ri; iVal++) {
                if (freq[iVal] == 0) {
                    continue;
                }
                int kMin = Math.max(lk, iVal - c);
                int kMax = Math.min(rk, iVal + c);
                if (kMin <= kMax) {
                    if (kMin == 0) {
                        count += freq[iVal] * suffixSum[kMax];
                    } else {
                        count += freq[iVal] * (suffixSum[kMax] - suffixSum[kMin - 1]);
                    }
                }
            }
            freq[mid]++;
            for (int v = arr[j + 1]; v <= 1000; v++) {
                suffixSum[v]--;
            }
        }
        return count;
    }

    public int countGoodTriplets2(int[] arr, int a, int b, int c) {
        int count = 0;
        int[] preSum = new int[1002];
        for (int j = 0; j < arr.length; j++) {
            for (int k = j + 1; k < arr.length; k++) {
                if (Math.abs(arr[j] - arr[k]) <= b) {
                    int li = Math.max(Math.max(arr[j] - a, 0), arr[k] - c);
                    int ri = Math.min(Math.min(arr[j] + a, 1000), arr[k] + c);
                    if (li <= ri) {
                        count += preSum[ri + 1] - preSum[li];
                    }
                }
            }
            for (int i = arr[j] + 1; i <= 1001; i++) {
                preSum[i]++;
            }
        }
        return count;
    }

    public int countGoodTriplets1(int[] arr, int a, int b, int c) {
        int count = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                if (Math.abs(arr[i] - arr[j]) <= a) {
                    for (int k = j + 1; k < arr.length; k++) {
                        if (Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[i] - arr[k]) <= c) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountGoodTriplets c = new CountGoodTriplets();
        assert c.countGoodTriplets(new int[]{3, 0, 1, 1, 9, 7}, 7, 2, 3) == 4;
        assert c.countGoodTriplets(new int[]{1, 1, 2, 2, 3}, 0, 0, 1) == 0;
    }
}
