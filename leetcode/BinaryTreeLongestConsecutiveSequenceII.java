package leetcode;

// https://leetcode.com/problems/binary-tree-longest-consecutive-sequence-ii/description/
// 549. Binary Tree Longest Consecutive Sequence II

public class BinaryTreeLongestConsecutiveSequenceII {
    int max = 0;

    public int longestConsecutive(TreeNode root) {
        rec(root);
        return max;
    }

    private int[] rec(TreeNode node) {
        int[] res = new int[2];

        if (node == null)
            return res;

        int[] left = rec(node.left);
        int[] right = rec(node.right);

        if (node.left != null) {
            if (node.left.val != node.val - 1) left[0] = 0; // for decreasing sequence
            if (node.left.val != node.val + 1) left[1] = 0; // for increasing sequence
        }

        if (node.right != null) {
            if (node.right.val != node.val - 1) right[0] = 0; // same as for left, this is for decreasing
            if (node.right.val != node.val + 1) right[1] = 0; // and this one for increasing
        }

        res[0] = Math.max(left[0], right[0]) + 1; // best decreasing sequence
        res[1] = Math.max(left[1], right[1]) + 1; // best increasing sequence

        // it could be that one branch is increasing, and one is increasing
        // and current node is connecting those sub-branches
        // that's why we need res[0] + res[1] - 1
        max = Math.max(max, res[0] + res[1] - 1);

        return res;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
