package com.leiqjl;

import java.util.ArrayList;
import java.util.List;

/**
 * 1382. Balance a Binary Search Tree - Medium
 *
 * Given the root of a binary search tree, return a balanced binary search tree with the same node values.
 * If there is more than one answer, return any of them.
 *
 * A binary search tree is balanced if the depth of the two subtrees of every node never differs by more than 1.
 */
public class BalanceABinarySearchTree {

    public TreeNode balanceBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<TreeNode> list = new ArrayList<>();
        inorder(root, list);
        return listToBST(list, 0, list.size() - 1);
    }

    private void inorder(TreeNode root, List<TreeNode> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root);
        inorder(root.right, list);
    }

    private TreeNode listToBST(List<TreeNode> list, int begin, int end) {
        if (begin > end) {
            return null;
        }
        int mid = (begin + end) / 2;
        TreeNode root = list.get(mid);
        root.left = listToBST(list, begin, mid - 1);
        root.right = listToBST(list, mid + 1, end);
        return root;
    }

    //dsw O(n) O(1)
    public TreeNode balanceBST1(TreeNode root) {
        TreeNode grand = new TreeNode(0);
        grand.right = root;
        int count = bstToVine(grand);
        int height = (int) (Math.log(count + 1) / Math.log(2));
        int m = (int) (Math.pow(2, height) - 1);
        compress(grand, count - m);
        for (m = m / 2; m > 0; m = m / 2) {
            compress(grand, m);
        }
        return grand.right;
    }

    public int bstToVine(TreeNode grand) {
        TreeNode oldTmp, tmp = grand.right;
        int count = 0;
        while (tmp != null) {
            // right rotation
            if (tmp.left != null) {
                oldTmp = tmp;
                tmp = tmp.left;
                grand.right = tmp;
                oldTmp.left = tmp.right;
                tmp.right = oldTmp;
            } else {
                grand = tmp;
                tmp = tmp.right;
                count++;
            }
        }
        return count;
    }

    public void compress(TreeNode grand, int m) {
        TreeNode oldTmp, tmp = grand.right;
        for (int i = 0; i < m; i++) {
            oldTmp = tmp;
            tmp = tmp.right;
            grand.right = tmp;
            oldTmp.right = tmp.left;
            tmp.left = oldTmp;

            grand = tmp;
            tmp = tmp.right;
        }
    }
}
