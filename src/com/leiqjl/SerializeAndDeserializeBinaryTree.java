package com.leiqjl;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 297. Serialize and Deserialize Binary Tree - Hard
 *
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer,
 * or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 *
 */
public class SerializeAndDeserializeBinaryTree {
    //[5,4,7,3,null,2,null,-1,null,9]

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder();
        inorderSerialize(root, res);
        return res.toString();
    }
    // 5 4 3 -1 X X X X 7 2 9 X X X X
    private void inorderSerialize(TreeNode root, StringBuilder res) {
        if (root == null) {
            res.append("X ");
            return;
        }
        res.append(root.val).append(" ");
        inorderSerialize(root.left, res);
        inorderSerialize(root.right, res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] s = data.split(" ");
        Deque<String> q = new ArrayDeque<>(Arrays.asList(s));
        return inorderDeserialize(q);
    }

    private TreeNode inorderDeserialize(Deque<String> q) {
        if (q.isEmpty()) {
            return null;
        }
        String val = q.remove();
        if (val.equals("X")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = inorderDeserialize(q);
        root.right = inorderDeserialize(q);
        return root;
    }

    // Encodes a tree to a single string.
    public String serialize1(TreeNode root) {
        StringBuilder res = new StringBuilder();
        postorderSerialize(root, res);
        return res.toString();
    }
    // X X -1 X 3 X 4 X X 9 X 2 X 7 5
    private void postorderSerialize(TreeNode root, StringBuilder res) {
        if (root == null) {
            res.append("X ");
            return;
        }
        postorderSerialize(root.left, res);
        postorderSerialize(root.right, res);
        res.append(root.val).append(" ");
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize1(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] valStr = data.split(" ");
        Deque<String> s = new ArrayDeque<>(Arrays.asList(valStr));
        return postorderDeserialize(s);
    }

    private TreeNode postorderDeserialize(Deque<String> s) {
        if (s.isEmpty()) {
            return null;
        }
        String val = s.removeLast();
        if (val.equals("X")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.right = postorderDeserialize(s);
        root.left = postorderDeserialize(s);
        return root;
    }


    // Encodes a tree to a single string.
    // 5 4 7 3 X 2 X -1 X 9 X X X X X
    public String serializeBFS(TreeNode root) {
        if (root == null) {
            return null;
        }
        StringBuilder res = new StringBuilder();
        Deque<TreeNode> q = new LinkedList<>();
        q.add(root);
        TreeNode p;
        while (!q.isEmpty()) {
            p = q.remove();
            if (p == null) {
                res.append("X ");
            } else {
                res.append(p.val).append(" ");
                q.add(p.left);
                q.add(p.right);
            }
        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserializeBFS(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] valStr = data.split(" ");
        Deque<TreeNode> q = new ArrayDeque<>();
        TreeNode root = new TreeNode(Integer.parseInt(valStr[0]));
        q.add(root);
        TreeNode p, l, r;
        for (int i = 1; i < valStr.length; i++) {
            p = q.remove();
            if (!valStr[i].equals("X")) {
                l = new TreeNode(Integer.parseInt(valStr[i]));
                p.left = l;
                q.add(l);
            }
            i++;
            if (!valStr[i].equals("X")) {
                r = new TreeNode(Integer.parseInt(valStr[i]));
                p.right = r;
                q.add(r);
            }
        }
        return root;
    }
}
