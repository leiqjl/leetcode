package com.leiqjl;

/**
 * 968. Binary Tree Cameras - Hard
 * <p>
 * You are given the root of a binary tree. We install cameras on the tree nodes where each camera at a node can monitor its parent, itself, and its immediate children.
 * <p>
 * Return the minimum number of cameras needed to monitor all nodes of the tree.
 */
public class BinaryTreeCameras {

    //The number of nodes in the tree is in the range [1, 1000].
    //Node.val == 0
    int count;

    public int minCameraCover(TreeNode root) {
        count = 0;
        int rootStatus = dfs(root);
        return rootStatus == 0 ? count + 1 : count;
    }

    // 0 need camera
    // 1 monitored
    // 2 camera
    private int dfs(TreeNode root) {
        if (root == null) {
            return 1;
        }
        int leftStatus = dfs(root.left);
        int rightStatus = dfs(root.right);
        // need camera
        if (leftStatus == 0 || rightStatus == 0) {
            count++;
            return 2;
        }
        // left or right has camera
        if (leftStatus == 2 || rightStatus == 2) {
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        BinaryTreeCameras b = new BinaryTreeCameras();

        SerializeAndDeserializeBinaryTree t = new SerializeAndDeserializeBinaryTree();
        //Input: root = [0,0,null,0,0]
        //Output: 1
        //Explanation: One camera is enough to monitor all nodes if placed as shown.
        String s = "0 0 X 0 0";
        TreeNode root = t.deserializeBFS(s);
        assert b.minCameraCover(root) == 1;

        //Input: root = [0,0,null,0,null,0,null,null,0]
        //Output: 2
        //Explanation: At least two cameras are needed to monitor all nodes of the tree. The above image shows one of the valid configurations of camera placement.
        s = "0 0 X 0 X 0 X X 0";
        root = t.deserializeBFS(s);
        assert b.minCameraCover(root) == 2;

        s = "0";
        root = t.deserializeBFS(s);
        assert b.minCameraCover(root) == 1;
    }
}
