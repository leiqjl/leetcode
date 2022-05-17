package com.leiqjl;

/**
 * 1379. Find a Corresponding Node of a Binary Tree in a Clone of That Tree - Medium
 */
public class FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree {
    //The number of nodes in the tree is in the range [1, 104].
    //The values of the nodes of the tree are unique.
    //target node is a node from the original tree and is not null.
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null || original == target) {
            return cloned;
        }
        TreeNode left = getTargetCopy(original.left, cloned.left, target);
        if (left != null) {
            return left;
        }
        return getTargetCopy(original.right, cloned.right, target);
    }

}
