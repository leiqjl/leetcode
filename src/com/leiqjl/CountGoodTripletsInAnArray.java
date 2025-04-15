package com.leiqjl;

/**
 * 2179. Count Good Triplets in an Array - Hard
 * You are given two 0-indexed arrays nums1 and nums2 of length n, both of which are permutations of [0, 1, ..., n - 1].
 * <p>
 * A good triplet is a set of 3 distinct values which are present in increasing order by position both in nums1 and nums2.
 * In other words, if we consider pos1v as the index of the value v in nums1 and pos2v as the index of the value v in nums2,
 * then a good triplet will be a set (x, y, z) where 0 <= x, y, z <= n - 1, such that pos1x < pos1y < pos1z and pos2x < pos2y < pos2z.
 * <p>
 * Return the total number of good triplets.
 */
public class CountGoodTripletsInAnArray {
    int[] fenwickTree;

    public void add(int idx, int val) {
        for (int i = idx + 1; i < fenwickTree.length; i += i & (-i)) {
            fenwickTree[i] += val;
        }
    }

    public int prefixSum(int idx) {
        int sum = 0;
        for (int i = idx + 1; i > 0; i -= i & (-i)) {
            sum += fenwickTree[i];
        }
        return sum;
    }

    public long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;
        fenwickTree = new int[n + 1];
        int[] indexes = new int[n];
        for (int i = 0; i < n; i++) {
            indexes[nums2[i]] = i;
        }
        long ans = 0;
        for (int i = 0; i < n - 1; i++) {
            int index = indexes[nums1[i]];
            int smaller = prefixSum(index);
            int greater = n - 1 - index - (i - smaller);
            ans += (long) smaller * greater;
            add(index, 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        CountGoodTripletsInAnArray c = new CountGoodTripletsInAnArray();
        assert c.goodTriplets(new int[]{2, 0, 1, 3}, new int[]{0, 1, 2, 3}) == 1;
        assert c.goodTriplets(new int[]{4, 0, 1, 3, 2}, new int[]{4, 1, 0, 2, 3}) == 4;
    }
}
