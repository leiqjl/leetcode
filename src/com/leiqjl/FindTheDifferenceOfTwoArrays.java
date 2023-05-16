package com.leiqjl;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 2215. Find the Difference of Two Arrays - Easy
 */
public class FindTheDifferenceOfTwoArrays {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());

        List<Integer> list1 = set1.stream().filter(o -> !set2.contains(o)).collect(Collectors.toList());
        List<Integer> list2 = set2.stream().filter(o -> !set1.contains(o)).collect(Collectors.toList());

        return List.of(list1,list2);
    }
}
