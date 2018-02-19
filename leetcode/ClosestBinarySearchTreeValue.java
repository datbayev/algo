package leetcode;

// https://leetcode.com/problems/closest-binary-search-tree-value/description/
// 270. Closest Binary Search Tree Value

public class ClosestBinarySearchTreeValue {
    double EPS = 1e-7;
    int min = Integer.MAX_VALUE;
    double minDiff = Double.MAX_VALUE;

    public int closestValue(TreeNode root, double target) {
        rec(root, target);
        return min;
    }

    private void rec(TreeNode node, double target) {
        double diff = Math.abs(node.val * 1.0 - target);
        if (Math.abs(diff) < minDiff) {
            min = node.val;
            minDiff = diff;
        }

        if (node.left != null)
            rec(node.left, target);

        if (node.right != null)
            rec(node.right, target);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
