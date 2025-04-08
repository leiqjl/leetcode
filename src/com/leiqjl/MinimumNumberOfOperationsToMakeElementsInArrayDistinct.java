package com.leiqjl;

/**
 * 3396. Minimum Number of Operations to Make Elements in Array Distinct - Easy
 */
public class MinimumNumberOfOperationsToMakeElementsInArrayDistinct {
    //Constraints:
    //
    //1 <= nums.length <= 100
    //1 <= nums[i] <= 100
    public int minimumOperations(int[] nums) {
        boolean[] seen = new boolean[101];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (seen[nums[i]]) {
                return (i + 1 + 2) / 3;
            }
            seen[nums[i]] = true;
        }
        return 0;
    }

    public static void main(String[] args) {
        MinimumNumberOfOperationsToMakeElementsInArrayDistinct m = new MinimumNumberOfOperationsToMakeElementsInArrayDistinct();
        assert m.minimumOperations(new int[]{1, 2, 3, 4, 2, 3, 3, 5, 7}) == 2;
        assert m.minimumOperations(new int[]{4, 5, 6, 4, 4}) == 2;
        assert m.minimumOperations(new int[]{6, 7, 8, 9}) == 0;
    }
}
