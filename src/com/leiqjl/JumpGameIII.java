package com.leiqjl;

/**
 * 1306. Jump Game III — Medium
 * Given an array of non-negative integers arr, you are initially positioned at start index of the array.
 * When you are at index i, you can jump to i + arr[i] or i - arr[i], check if you can reach to any index with value 0.
 * <p>
 * Notice that you can not jump outside of the array at any time.
 */
public class JumpGameIII {

    public boolean canReach(int[] arr, int start) {
        return bfs(arr, start);
    }

    private boolean bfs(int[] arr, int s) {
        if (s < 0 || s >= arr.length || arr[s] < 0) {
            return false;
        }
        if (arr[s] == 0) {
            return true;
        }
        arr[s] = -arr[s];
        return bfs(arr, s + arr[s]) || bfs(arr, s - arr[s]);
    }

    public static void main(String[] args) {
        JumpGameIII j = new JumpGameIII();
        //Input: arr = [4,2,3,0,3,1,2], start = 5
        //Output: true
        int[] arr = {4, 2, 3, 0, 3, 1, 2};
        assert j.canReach(arr, 5);
        //Input: arr = [4,2,3,0,3,1,2], start = 0
        //Output: true
        int[] arr1 = {4, 2, 3, 0, 3, 1, 2};
        assert j.canReach(arr1, 0);
        //Input: arr = [3,0,2,1,2], start = 2
        //Output: false
        int[] arr2 = {3, 0, 2, 1, 2};
        assert !j.canReach(arr2, 2);
    }
}
