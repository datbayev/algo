package leetcode;

// https://leetcode.com/problems/invert-binary-tree/description/
// 226. Invert Binary Tree

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;

        rec(root);

        return root;
    }

    private void rec(TreeNode node) {
        if (node == null)
            return;

        if (node.left != null || node.right != null) {
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            invertTree(node.left);
            invertTree(node.right);
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
