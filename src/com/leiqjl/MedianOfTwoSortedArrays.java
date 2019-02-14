package com.leiqjl;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays.
 * The overall run time complexity should be O(log (m+n)).
 * You may assume nums1 and nums2 cannot be both empty.
 */
public class MedianOfTwoSortedArrays {

    /**
     *  nums1[i-1] <= nums2[j]
     *  nums2[j-1] <= nums1[i]
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 > len2) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int min = 0, max = len1, halfLen = (len1 + len2 + 1) / 2;
        while (min <= max) {
            int i = (min + max) / 2;
            int j = halfLen - i;
            if (i < max && nums2[j - 1] > nums1[i]) {
                min = i + 1;
            } else if (i > min && nums1[i - 1] > nums2[j]) {
                max = i - 1;
            } else {
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = nums2[j-1];
                } else if (j == 0) {
                    maxLeft = nums1[i-1];
                } else {
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                if ((len1 + len2) % 2 == 1) {
                    return maxLeft;
                }
                int minRight = 0;
                if (i == len1) {
                    minRight = nums2[j];
                } else if (j == len2) {
                    minRight = nums1[i];
                } else {
                    minRight = Math.min(nums1[i], nums2[j]);
                }
                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays test = new MedianOfTwoSortedArrays();
        int[] a = {1,3};
        int[] b = {2};
        System.out.println(test.findMedianSortedArrays(a,b));
        a = new int[]{};
        b = new int[]{1};
        System.out.println(test.findMedianSortedArrays(a,b));

    }
}
