package leetcode;

// https://leetcode.com/problems/longest-univalue-path/description/
// 687. Longest Univalue Path

public class LongestUnivaluePath {
    int max = 0;

    public int longestUnivaluePath(TreeNode root) {
        maxPath(root);
        return max;
    }

    public int maxPath(TreeNode node) {
        if (node == null)
            return 0;

        int left = 0;
        if (node.left != null && node.left.val == node.val)
            left += maxPath(node.left) + 1;
        else
            maxPath(node.left);

        int right = 0;
        if (node.right != null && node.right.val == node.val)
            right += maxPath(node.right) + 1;
        else
            maxPath(node.right);

        max = Math.max(max, left + right);

        return Math.max(left, right);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
