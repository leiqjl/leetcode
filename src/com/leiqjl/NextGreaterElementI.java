package com.leiqjl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 496. Next Greater Element I - Easy
 */
public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] stack = new int[nums2.length];
        int idx = -1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int j : nums2) {
            while (idx > -1 && j > stack[idx]) {
                map.put(stack[idx--], j);
            }
            stack[++idx] = j;
        }
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.getOrDefault(nums1[i], -1);
        }
        return result;
    }

    public static void main(String[] args) {
        NextGreaterElementI n = new NextGreaterElementI();
        System.out.println(Arrays.toString(n.nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})));
    }
}
