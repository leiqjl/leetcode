package com.leiqjl;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

/***
 * 480. Sliding Window Median - Hard
 */
public class SlidingWindowMedian {
    //Constraints:
    //
    //1 <= k <= nums.length <= 10^5
    //-2^31 <= nums[i] <= 2^31 - 1
    //295. Find Median from Data Stream
    public double[] medianSlidingWindow(int[] nums, int k) {
        Comparator<Integer> comparator = (a, b) -> nums[a] == nums[b] ? a - b : Integer.compare(nums[a], nums[b]);
        TreeSet<Integer> maxTreeSet = new TreeSet<>(comparator.reversed());
        TreeSet<Integer> minTreeSet = new TreeSet<>(comparator);
        double[] res = new double[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {

            if (i >= k) {
                if (!maxTreeSet.remove(i - k)) {
                    minTreeSet.remove(i - k);
                }
            }

            maxTreeSet.add(i);
            minTreeSet.add(maxTreeSet.removeFirst());

            //balance
            while (minTreeSet.size() > maxTreeSet.size()) {
                maxTreeSet.add(minTreeSet.pollFirst());
            }
            //get median
            if (i >= k - 1) {
                if (k % 2 == 0) {
                    res[i - k + 1] = ((double) nums[maxTreeSet.first()] + nums[minTreeSet.first()]) / 2.0;
                } else {
                    res[i - k + 1] = nums[maxTreeSet.first()];
                }
            }
        }
        return res;
    }

    private void balance(TreeSet<Integer> maxTreeSet, TreeSet<Integer> minTreeSet) {
        while (minTreeSet.size() > maxTreeSet.size()) {
            maxTreeSet.add(minTreeSet.pollFirst());
        }
    }

    public static void main(String[] args) {
        SlidingWindowMedian s = new SlidingWindowMedian();
        //Window position                Median
        //---------------                -----
        //[1  3  -1] -3  5  3  6  7        1
        // 1 [3  -1  -3] 5  3  6  7       -1
        // 1  3 [-1  -3  5] 3  6  7       -1
        // 1  3  -1 [-3  5  3] 6  7        3
        // 1  3  -1  -3 [5  3  6] 7        5
        // 1  3  -1  -3  5 [3  6  7]       6
        System.out.println(Arrays.toString(s.medianSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
        System.out.println(Arrays.toString(s.medianSlidingWindow(new int[]{1, 2, 3, 4, 2, 3, 1, 4, 2}, 3)));
        System.out.println(Arrays.toString(s.medianSlidingWindow(new int[]{2147483647, 2147483647}, 2)));
    }
}
