package com.leiqjl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 652. Find Duplicate Subtrees - Medium
 * <p>
 * Given the root of a binary tree, return all duplicate subtrees.
 * <p>
 * For each kind of duplicate subtrees, you only need to return the root node of any one of them.
 * <p>
 * Two trees are duplicate if they have the same structure with the same node values.
 * <p>
 * Constraints:
 * - The number of the nodes in the tree will be in the range [1, 10^4]
 * - -200 <= Node.val <= 200
 */
public class FindDuplicateSubtrees {

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, Integer> map = new HashMap<>();
        List<TreeNode> res = new LinkedList<>();
        findDuplicateSubtreesHelper(root, map, res);
        return res;
    }

    private String findDuplicateSubtreesHelper(TreeNode root, Map<String, Integer> map, List<TreeNode> res) {
        if (root == null) {
            return "#";
        }
        String left = findDuplicateSubtreesHelper(root.left, map, res);
        String right = findDuplicateSubtreesHelper(root.right, map, res);
        String subtreeStr = left + "," + right + "," + root.val;
        int count = map.getOrDefault(subtreeStr, 0);
        if (count == 1) {
            res.add(root);
        }
        map.put(subtreeStr, count + 1);
        return subtreeStr;
    }

}
