package leetcode;

// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/
// 114. Flatten Binary Tree to Linked List

public class FlattenBinaryTreeToLinkedList {
    TreeNode last = null;

    public void flatten(TreeNode root) {
        if (root == null)
            return;

        rec(root);
    }

    private void rec(TreeNode node) {
        if (node == null)
            return;

        TreeNode left = node.left;
        TreeNode right = node.right;

        if (last != null) {
            last.right = node;
            last.left =  null;
        }

        last = node;

        rec(left);
        rec(right);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
