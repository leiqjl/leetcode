package com.leiqjl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 349. Intersection of Two Arrays - Easy
 */
public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums1) {
            hashSet.add(num);
        }
        List<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            if (hashSet.contains(num)) {
                list.add(num);
                hashSet.remove(num);
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}
