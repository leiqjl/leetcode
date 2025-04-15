package com.leiqjl;

import java.util.Arrays;
import java.util.List;

/**
 * 315. Count of Smaller Numbers After Self - Hard
 * Given an integer array nums, return an integer array counts where counts[i] is the number of smaller elements to the right of nums[i].
 */
public class CountOfSmallerNumbersAfterSelf {

    //Constraints:
    //
    //1 <= nums.length <= 10^5
    //-104 <= nums[i] <= 10^4
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[] counts = new int[n];
        int[] indexes = new int[n];
        for (int i = 0; i < n; i++) {
            indexes[i] = i;
        }
        mergeSort(nums, indexes, counts, 0, n - 1);
        List<Integer> list = Arrays.stream(counts).boxed().toList();
        return list;
    }

    private void mergeSort(int[] nums, int[] indexes, int[] counts, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(nums, indexes, counts, left, mid);
        mergeSort(nums, indexes, counts, mid + 1, right);

        merge(nums, indexes, counts, left, right);
    }

    private void merge(int[] nums, int[] indexes, int[] counts, int left, int right) {
        int mid = (left + right) / 2;
        int leftIndex = left;
        int rightIndex = mid + 1;
        int[] temp = new int[right - left + 1];
        int count = 0;
        int tempIndex = 0;
        while (leftIndex <= mid && rightIndex <= right) {
            if (nums[indexes[leftIndex]] > nums[indexes[rightIndex]]) {
                count++;
                temp[tempIndex++] = indexes[rightIndex++];
            } else {
                counts[indexes[leftIndex]] += count;
                temp[tempIndex++] = indexes[leftIndex++];
            }
        }
        while (leftIndex <= mid) {
            counts[indexes[leftIndex]] += count;
            temp[tempIndex++] = indexes[leftIndex++];
        }
        while (rightIndex <= right) {
            temp[tempIndex++] = indexes[rightIndex++];
        }
        for (int i = 0; i < temp.length; i++) {
            indexes[i + left] = temp[i];
        }
    }

    public static void main(String[] args) {
        CountOfSmallerNumbersAfterSelf c = new CountOfSmallerNumbersAfterSelf();
        //Input: nums = [5,2,6,1]
        //Output: [2,1,1,0]
        //Explanation:
        //To the right of 5 there are 2 smaller elements (2 and 1).
        //To the right of 2 there is only 1 smaller element (1).
        //To the right of 6 there is 1 smaller element (1).
        //To the right of 1 there is 0 smaller element.
        assert c.countSmaller(new int[]{5, 2, 6, 1}).equals(List.of(2, 1, 1, 0));
        assert c.countSmaller(new int[]{-1}).equals(List.of(0));
        assert c.countSmaller(new int[]{-1, -1}).equals(List.of(0, 0));
        assert c.countSmaller(new int[]{2, 0, 1}).equals(List.of(2, 0, 0));
    }
}
