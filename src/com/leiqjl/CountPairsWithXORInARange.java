package com.leiqjl;

/**
 * 1803. Count Pairs With XOR in a Range - Hard
 * <p>
 * Given a (0-indexed) integer array nums and two integers low and high, return the number of nice pairs.
 * <p>
 * A nice pair is a pair (i, j) where 0 <= i < j < nums.length and low <= (nums[i] XOR nums[j]) <= high.
 */
public class CountPairsWithXORInARange {
    class Trie {
        Trie[] children;
        int count;

        Trie() {
            children = new Trie[2];
            count = 0;
        }

    }

    private void insert(Trie root, int n) {
        for (int i = 14; i >= 0; i--) {
            int ibit = (n >> i) & 1;
            if (root.children[ibit] == null) {
                root.children[ibit] = new Trie();
            }
            root.children[ibit].count++;
            root = root.children[ibit];
        }
    }

    private int countLessThanK(Trie root, int x, int k) {
        int count = 0;
        for (int i = 14; i >= 0 && root != null; i--) {
            int xBit = (x >> i) & 1;
            int kBit = (k >> i) & 1;
            //kBit=0, xBit ^ n = 0
            if (kBit == 0) {
                root = root.children[xBit];
                continue;
            }

            // kBit =1
            // xBit^n = 0, count+=root.children[xBit].count
            if (root.children[xBit] != null) {
                count += root.children[xBit].count;
            }
            //xBit^n =1
            root = root.children[1 - xBit];
        }
        return count;
    }

    public int countPairs(int[] nums, int low, int high) {
        Trie root = new Trie();
        int count = 0;
        for (int num : nums) {
            count = count + countLessThanK(root, num, high + 1) - countLessThanK(root, num, low);
            insert(root, num);
        }
        return count;
    }


    public static void main(String[] args) {
        CountPairsWithXORInARange t = new CountPairsWithXORInARange();
        //Input: nums = [1,4,2,7], low = 2, high = 6
        //Output: 6
        //Explanation: All nice pairs (i, j) are as follows:
        //    - (0, 1): nums[0] XOR nums[1] = 5
        //    - (0, 2): nums[0] XOR nums[2] = 3
        //    - (0, 3): nums[0] XOR nums[3] = 6
        //    - (1, 2): nums[1] XOR nums[2] = 6
        //    - (1, 3): nums[1] XOR nums[3] = 3
        //    - (2, 3): nums[2] XOR nums[3] = 5
        int[] nums = {1, 4, 2, 7};
        assert t.countPairs(nums, 2, 6) == 6;
        //Input: nums = [9,8,4,2,1], low = 5, high = 14
        //Output: 8
        //Explanation: All nice pairs (i, j) are as follows:
        //    - (0, 2): nums[0] XOR nums[2] = 13
        //    - (0, 3): nums[0] XOR nums[3] = 11
        //    - (0, 4): nums[0] XOR nums[4] = 8
        //    - (1, 2): nums[1] XOR nums[2] = 12
        //    - (1, 3): nums[1] XOR nums[3] = 10
        //    - (1, 4): nums[1] XOR nums[4] = 9
        //    - (2, 3): nums[2] XOR nums[3] = 6
        //    - (2, 4): nums[2] XOR nums[4] = 5
        int[] nums1 = {9, 8, 4, 2, 1};
        assert t.countPairs(nums1, 5, 14) == 8;
    }
}
