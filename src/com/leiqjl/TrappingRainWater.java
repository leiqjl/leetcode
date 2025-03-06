package com.leiqjl;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 42. Trapping Rain Water - Hard
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 */
public class TrappingRainWater {
    //Constraints:
    //
    //n == height.length
    //1 <= n <= 2 * 10^4
    //0 <= height[i] <= 10^5

    //two pointers
    public int trap(int[] height) {
        int res = 0;
        int left = 0, right = height.length - 1;
        int leftMax = height[left], rightMax = height[right];
        while (left < right) {
            if (leftMax < rightMax) {
                left++;
                if (height[left] < leftMax) {
                    res += leftMax - height[left];
                } else {
                    leftMax = height[left];
                }
            } else {
                right--;
                if (height[right] < rightMax) {
                    res += rightMax - height[right];
                } else {
                    rightMax = height[right];
                }
            }
        }
        return res;
    }

    public int trap1(int[] height) {
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < height.length; i++) {
            int h = height[i];
            if (h == 0) {
                continue;
            }
            int lastHeight = 0;
            while (!stack.isEmpty() && height[stack.peek()] <= h) {
                int idx = stack.pop();
                int popHeight = height[idx];
                res += (popHeight - lastHeight) * (i - idx - 1);
                lastHeight = popHeight;
            }
            if (!stack.isEmpty() && height[stack.peek()] > h) {
                res += (h - lastHeight) * (i - stack.peek() - 1);
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        TrappingRainWater t = new TrappingRainWater();
        assert t.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}) == 6;
        assert t.trap(new int[]{4, 2, 0, 3, 2, 5}) == 9;
    }
}
