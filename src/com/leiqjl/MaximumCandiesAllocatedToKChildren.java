package com.leiqjl;

/**
 * 2226. Maximum Candies Allocated to K Children - Medium
 * You are given a 0-indexed integer array candies. Each element in the array denotes a pile of candies of size candies[i]. You can divide each pile into any number of sub piles, but you cannot merge two piles together.
 * <p>
 * You are also given an integer k. You should allocate piles of candies to k children such that each child gets the same number of candies. Each child can be allocated candies from only one pile of candies and some piles of candies may go unused.
 * <p>
 * Return the maximum number of candies each child can get.
 */
public class MaximumCandiesAllocatedToKChildren {
    //Constraints:
    //
    //1 <= candies.length <= 10^5
    //1 <= candies[i] <= 10^7
    //1 <= k <= 10^12
    public int maximumCandies(int[] candies, long k) {
        int max = 0;
        for (int candie : candies) {
            max = Math.max(max, candie);
        }
        int left = 0, right = max;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (canAllocate(candies, k, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private boolean canAllocate(int[] candies, long k, int num) {
        long sum = 0;
        for (int candie : candies) {
            sum += candie / num;
        }
        return sum >= k;
    }


    public static void main(String[] args) {
        MaximumCandiesAllocatedToKChildren m = new MaximumCandiesAllocatedToKChildren();
        //5 5 3 5 1
        assert m.maximumCandies(new int[]{5, 8, 6}, 3) == 5;
        assert m.maximumCandies(new int[]{2, 5}, 11) == 0;
    }
}
