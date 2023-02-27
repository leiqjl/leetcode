package com.leiqjl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 932. Beautiful Array - Medium
 * An array nums of length n is beautiful if:
 * <p>
 * - nums is a permutation of the integers in the range [1, n].
 * - For every 0 <= i < j < n, there is no index k with i < k < j where 2 * nums[k] == nums[i] + nums[j].
 * Given the integer n, return any beautiful array nums of length n. There will be at least one valid answer for the given n.
 */
public class BeautifulArray {
    //Constraints:
    //1 <= n <= 1000
    public int[] beautifulArray(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        while (list.size() < n) {
            List<Integer> tempList = new ArrayList<>();
            for (int num : list) {
                if ((num * 2 - 1) <= n) {
                    tempList.add(num * 2 - 1);
                }
            }
            for (int num : list) {
                if (num * 2 <= n) {
                    tempList.add(num * 2);
                }
            }
            list = tempList;
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        BeautifulArray b = new BeautifulArray();
        //Input: n = 4
        //Output: [2,1,4,3]
        System.out.println(Arrays.toString(b.beautifulArray(4)));
        //Input: n = 5
        //Output: [3,1,2,5,4]
        System.out.println(Arrays.toString(b.beautifulArray(5)));
    }
}
