package leetcode;

// https://leetcode.com/problems/validate-binary-search-tree/
// 98. Validate Binary Search Tree

class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return true;

        return rec(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean rec(TreeNode root, long min, long max) {
        if (root == null)
            return true;

        if ((long)(root.val) <= min || (long)(root.val) >= max)
            return false;

        return rec(root.left, min, (long)(root.val)) && rec(root.right, (long)(root.val), max);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
