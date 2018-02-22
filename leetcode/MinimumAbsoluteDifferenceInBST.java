package leetcode;

// https://leetcode.com/problems/minimum-absolute-difference-in-bst/description/
// 530. Minimum Absolute Difference in BST

public class MinimumAbsoluteDifferenceInBST {
    int min = Integer.MAX_VALUE;
    TreeNode prev = null;

    public int getMinimumDifference(TreeNode root) {
        if (root == null)
            return 0;
        rec(root);
        return min;
    }

    private void rec(TreeNode node) {
        if (node == null)
            return;

        rec(node.left);

        if (prev != null)
            min = Math.min(min, Math.abs(node.val - prev.val));
        prev = node;

        rec(node.right);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
