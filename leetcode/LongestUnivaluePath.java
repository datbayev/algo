package leetcode;

// https://leetcode.com/problems/longest-univalue-path/description/
// 687. Longest Univalue Path

public class LongestUnivaluePath {
    int max = 0;

    public int longestUnivaluePath(TreeNode root) {
        rec(root);
        return max;
    }

    private int rec(TreeNode root) {
        if (root == null)
            return 0;

        int right = rec(root.right), left = rec(root.left);
        int arrowLeft = 0, arrowRight = 0;

        if (root.left != null && root.left.val == root.val)
            arrowLeft = left + 1; // left node itself and everything attached to it

        if (root.right != null && root.right.val == root.val)
            arrowRight = right + 1; // right node itself and everything attached to it

        max = Math.max(max, arrowLeft + arrowRight);

        return Math.max(arrowLeft, arrowRight);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
