package com.leiqjl;

import java.util.ArrayList;
import java.util.List;

/**
 * 658. Find K Closest Elements - Medium
 * <p>
 * Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array.
 * The result should also be sorted in ascending order.
 * <p>
 * An integer a is closer to x than an integer b if:
 * <p>
 * |a - x| < |b - x|, or
 * |a - x| == |b - x| and a < b
 */
public class FindKClosestElements {
    //Constraints:
    //
    //1 <= k <= arr.length
    //1 <= arr.length <= 10^4
    //arr is sorted in ascending order.
    //-10^4 <= arr[i], x <= 10^4

    // arr[mid] arr[mid+1]...arr[mid+k-1]
    //          arr[mid+1]...arr[mid+k-1] arr[mid+k]
    // x-arr[mid]>arr[mid+k]-x  l=mid+1
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0, r = arr.length - k;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (x - arr[mid] <= arr[mid + k] - x) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        List<Integer> result = new ArrayList<>(k);
        for (int i = l; i < l + k; i++) {
            result.add(arr[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        FindKClosestElements f = new FindKClosestElements();
        //Input: arr = [1,2,3,4,5], k = 4, x = 3
        //Output: [1,2,3,4]
        int[] arr = {1, 2, 3, 4, 5};
        assert f.findClosestElements(arr, 4, 3).toString().equals("[1, 2, 3, 4]");
        //Input: arr = [1,2,3,4,5], k = 4, x = -1
        //Output: [1,2,3,4]
        assert f.findClosestElements(arr, 4, -1).toString().equals("[1, 2, 3, 4]");
        assert f.findClosestElements(new int[]{1}, 1, 1).toString().equals("[1]");
    }
}
