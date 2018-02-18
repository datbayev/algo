package leetcode;

// https://leetcode.com/problems/binary-tree-longest-consecutive-sequence/description/
// 298. Binary Tree Longest Consecutive Sequence

public class BinaryTreeLongestConsecutiveSequence {
    int max = 0;

    public int longestConsecutive(TreeNode root) {
        if (root == null)
            return 0;

        rec(root);
        return max;
    }

    private int rec(TreeNode node) {
        if (node == null)
            return 1;

        int left = rec(node.left);
        int right = rec(node.right);

        int arrowLeft = 0;
        int arrowRight = 0;

        if (node.left != null && node.left.val - node.val == 1)
            arrowLeft = left + 1;

        if (node.right != null && node.right.val - node.val == 1)
            arrowRight = right + 1;

        max = Math.max(max, Math.max(arrowLeft, arrowRight) + 1);

        return Math.max(arrowLeft, arrowRight);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
