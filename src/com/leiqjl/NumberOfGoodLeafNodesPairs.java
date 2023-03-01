package com.leiqjl;

/**
 * 1530. Number of Good Leaf Nodes Pairs - Medium
 */
public class NumberOfGoodLeafNodesPairs {
    //Constraints:
    //The number of nodes in the tree is in the range [1, 2^10].
    //1 <= Node.val <= 100
    //1 <= distance <= 10
    int count = 0;

    public int countPairs(TreeNode root, int distance) {
        postorder(root, distance);
        return count;
    }

    public int[] postorder(TreeNode root, int distance) {
        if (root == null) {
            return new int[distance + 1];
        }
        if (root.left == null && root.right == null) {
            int[] dis = new int[distance + 1];
            dis[1]++;
            return dis;
        }
        int[] leftDis = postorder(root.left, distance);
        int[] rightDis = postorder(root.right, distance);
        for (int i = 1; i < distance; i++) {
            for (int j = distance - 1; j > 0; j--) {
                if (i + j <= distance && leftDis[i] > 0 && rightDis[j] > 0) {
                    count += leftDis[i] * rightDis[j];
                }
            }
        }
        int[] dis = new int[distance + 1];
        for (int i = 1; i < distance; i++) {
            dis[i + 1] = leftDis[i] + rightDis[i];
        }
        return dis;
    }
}
