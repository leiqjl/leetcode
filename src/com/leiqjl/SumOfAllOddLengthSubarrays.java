package com.leiqjl;

/**
 * 1588. Sum of All Odd Length Subarrays - Easy
 */
public class SumOfAllOddLengthSubarrays {
    //12345
    //(i+1)*(n-i)
    //i=1, begin 1 2
    //     end   2 3 4 5
    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + (((i + 1) * (n - i) + 1) / 2 * arr[i]);
        }
        return sum;
    }

    public static void main(String[] args) {
        SumOfAllOddLengthSubarrays s = new SumOfAllOddLengthSubarrays();
        //Input: arr = [1,4,2,5,3]
        //Output: 58
        assert s.sumOddLengthSubarrays(new int[]{1, 4, 2, 5, 3}) == 58;
        //Input: arr = [1,2]
        //Output: 3
        assert s.sumOddLengthSubarrays(new int[]{1, 2}) == 3;
        //Input: arr = [10,11,12]
        //Output: 66
        assert s.sumOddLengthSubarrays(new int[]{10, 11, 12}) == 66;
    }
}
