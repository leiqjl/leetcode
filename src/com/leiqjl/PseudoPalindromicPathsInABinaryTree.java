package com.leiqjl;

/**
 * 1457. Pseudo-Palindromic Paths in a Binary Tree - Medium
 */
public class PseudoPalindromicPathsInABinaryTree {
    //The number of nodes in the tree is in the range [1, 105].
    //1 <= Node.val <= 9
    public int pseudoPalindromicPaths(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int count) {
        if (root == null) {
            return 0;
        }
        count = count ^ (1 << root.val);
        if (root.left == null && root.right == null) {
            if ((count & (count - 1)) == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        return dfs(root.left, count) + dfs(root.right, count);
    }


    public static void main(String[] args) {
        PseudoPalindromicPathsInABinaryTree p = new PseudoPalindromicPathsInABinaryTree();
        //Input: root = [2,3,1,3,1,null,1]
        //Output: 2
        //Explanation: The figure above represents the given binary tree.
        // There are three paths going from the root node to leaf nodes: the red path [2,3,3], the green path [2,1,1], and the path [2,3,1].
        // Among these paths only red path and green path are pseudo-palindromic paths since the red path [2,3,3] can be rearranged in [3,2,3] (palindrome)
        // and the green path [2,1,1] can be rearranged in [1,2,1] (palindrome).

        //Input: root = [2,1,1,1,3,null,null,null,null,null,1]
        //Output: 1
        //Explanation: The figure above represents the given binary tree.
        // There are three paths going from the root node to leaf nodes: the green path [2,1,1], the path [2,1,3,1], and the path [2,1].
        // Among these paths only the green path is pseudo-palindromic since [2,1,1] can be rearranged in [1,2,1] (palindrome).
    }
}
