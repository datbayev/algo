package leetcode;

// https://leetcode.com/problems/minimum-distance-between-bst-nodes/description/
// 783. Minimum Distance Between BST Nodes

public class MinimumDistanceBetweenBSTNodes {

    int prev = Integer.MAX_VALUE;
    int min = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        rec(root);
        return min;
    }

    private void rec(TreeNode node) {
        if (node == null)
            return;

        rec(node.left);

        if (prev != Integer.MAX_VALUE)
            min = Math.min(min, Math.abs(node.val - prev));
        prev = node.val;
        rec(node.right);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
