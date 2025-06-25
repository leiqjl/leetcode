package com.leiqjl;

/**
 * 2040. Kth Smallest Product of Two Sorted Arrays - Hard
 * Given two sorted 0-indexed integer arrays nums1 and nums2 as well as an integer k,
 * return the kth (1-based) smallest product of nums1[i] * nums2[j] where 0 <= i < nums1.length and 0 <= j < nums2.length.
 */
public class KthSmallestProductOfTwoSortedArrays {
    //1 <= nums1.length, nums2.length <= 5 * 10^4
    //-10^5 <= nums1[i], nums2[j] <= 10^5
    //1 <= k <= nums1.length * nums2.length
    //nums1 and nums2 are sorted.

    //nums1 - nums2 +
    //nums1 + nums2 -
    //nums1 - nums2 -
    //nums1 + nums2 +
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long left = -10_000_000_000L, right = 10_000_000_000L;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (count(nums1, nums2, mid) < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private long count(int[] nums1, int[] nums2, long target) {
        long count = 0;
        for (int x : nums1) {
            int l = 0, r = nums2.length - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                long product = x * (long) nums2[mid];
                if ((x >= 0 && product <= target) || (x < 0 && product > target)) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            if (x >= 0) {
                count += l;
            } else {
                count += (nums2.length - l);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        KthSmallestProductOfTwoSortedArrays k = new KthSmallestProductOfTwoSortedArrays();
        //Input: nums1 = [2,5], nums2 = [3,4], k = 2
        //Output: 8
        //Explanation: The 2 smallest products are:
        //- nums1[0] * nums2[0] = 2 * 3 = 6
        //- nums1[0] * nums2[1] = 2 * 4 = 8
        //The 2nd smallest product is 8.
        assert k.kthSmallestProduct(new int[]{2, 5}, new int[]{3, 4}, 2) == 8;
        //Input: nums1 = [-4,-2,0,3], nums2 = [2,4], k = 6
        //Output: 0
        //Explanation: The 6 smallest products are:
        //- nums1[0] * nums2[1] = (-4) * 4 = -16
        //- nums1[0] * nums2[0] = (-4) * 2 = -8
        //- nums1[1] * nums2[1] = (-2) * 4 = -8
        //- nums1[1] * nums2[0] = (-2) * 2 = -4
        //- nums1[2] * nums2[0] = 0 * 2 = 0
        //- nums1[2] * nums2[1] = 0 * 4 = 0
        //The 6th smallest product is 0.
        assert k.kthSmallestProduct(new int[]{-4, -2, 0, 3}, new int[]{2, 4}, 6) == 0;
        //Input: nums1 = [-2,-1,0,1,2], nums2 = [-3,-1,2,4,5], k = 3
        //Output: -6
        //Explanation: The 3 smallest products are:
        //- nums1[0] * nums2[4] = (-2) * 5 = -10
        //- nums1[0] * nums2[3] = (-2) * 4 = -8
        //- nums1[4] * nums2[0] = 2 * (-3) = -6
        //The 3rd smallest product is -6.
        assert k.kthSmallestProduct(new int[]{-2, -1, 0, 1, 2}, new int[]{-3, -1, 2, 4, 5}, 3) == -6;
    }
}
