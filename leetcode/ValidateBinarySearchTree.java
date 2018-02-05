package leetcode;

// https://leetcode.com/problems/validate-binary-search-tree/
// 98. Validate Binary Search Tree

class Solution {
    public boolean isValidBST(TreeNode root) {
        return rec(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean rec(TreeNode node, long min, long max) {
        return node == null ||
                node.val < max && node.val > min && rec(node.left, node.val, min) && rec(node.right, max, node.val);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
