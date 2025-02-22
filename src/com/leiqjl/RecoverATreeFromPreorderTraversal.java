package com.leiqjl;

/**
 * 1028. Recover a Tree From Preorder Traversal - Hard
 */
public class RecoverATreeFromPreorderTraversal {
    public TreeNode recoverFromPreorder(String traversal) {
        return recover(0, 1, traversal);
    }

    private TreeNode recover(int idx, int depth, String traversal) {
        int val = 0;
        while (idx <traversal.length() && traversal.charAt(idx) != '-') {
            val = val*10+traversal.charAt(idx) - '0';
            idx++;
        }
        TreeNode treeNode = new TreeNode(val);
        int d = 0;
        while (idx < traversal.length() && traversal.charAt(idx) == '-') {
            idx++;
            d++;
        }
        if (d != depth) {
            return treeNode;
        }
        treeNode.left = recover(idx, depth + 1, traversal);

        while (idx < traversal.length()) {
            while (idx < traversal.length() && traversal.charAt(idx) != '-') {
                idx++;
            }
            d = 0;
            while (idx < traversal.length() && traversal.charAt(idx) == '-') {
                idx++;
                d++;
            }
            if (d == depth) {
                treeNode.right = recover(idx, depth + 1, traversal);
                break;
            } else {
                if (d < depth) {
                    break;
                }
                idx++;
            }
        }
        return treeNode;
    }

    public static void main(String[] args) {
        RecoverATreeFromPreorderTraversal r = new RecoverATreeFromPreorderTraversal();
        TreeNode treeNode = r.recoverFromPreorder("1-2--3---4-5--6---7");
        TreeNode treeNode1 = r.recoverFromPreorder("1-401--349---90--88");
        System.out.println(treeNode1);
    }
}
