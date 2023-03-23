package com.leiqjl;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 2196. Create Binary Tree From Descriptions - Medium
 */
public class CreateBinaryTreeFromDescriptions {
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer, TreeNode> hashMap = new HashMap<>();
        HashSet<Integer> hashSet = new HashSet<>();
        for (int[] des : descriptions) {
            TreeNode parent = hashMap.getOrDefault(des[0], new TreeNode(des[0]));

            hashSet.add(des[1]);
            TreeNode child = hashMap.getOrDefault(des[1], new TreeNode(des[1]));
            if (des[2] == 1) {
                parent.left = child;
            } else {
                parent.right = child;
            }
            hashMap.put(des[1], child);

            hashMap.put(des[0], parent);
        }
        int rootVal = -1;
        for (int[] des : descriptions) {
            if (!hashSet.contains(des[0])) {
                rootVal = des[0];
            }
        }
        return hashMap.get(rootVal);
    }
}
