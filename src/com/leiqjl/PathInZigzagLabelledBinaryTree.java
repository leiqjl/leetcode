package com.leiqjl;

import java.util.*;

/**
 * 1104. Path In Zigzag Labelled Binary Tree - Medium
 */
public class PathInZigzagLabelledBinaryTree {
    public List<Integer> pathInZigZagTree(int label) {
        int tmp = label, level = 0;
        while (tmp > 0) {
            tmp /= 2;
            level++;
        }
        List<Integer> result = new ArrayList<>(level);
        boolean flag = true;
        while (level > 0) {
            level--;
            if (flag) {
                result.add(label);
            } else {
                result.add(((1 << level) * 3 - 1 - label));
            }
            label /= 2;
            flag = !flag;
        }
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        PathInZigzagLabelledBinaryTree p = new PathInZigzagLabelledBinaryTree();
        assert "[1, 3, 4, 14]".equals(p.pathInZigZagTree(14).toString());
        assert "[1, 2, 6, 10, 26]".equals(p.pathInZigZagTree(26).toString());
    }
}
