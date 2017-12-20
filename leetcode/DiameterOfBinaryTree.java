package leetcode;

// https://leetcode.com/problems/diameter-of-binary-tree/description/
// 543. Diameter of Binary Tree

class DiameterOfBinaryTree {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        rec(root);
        return max;
    }

    public int rec(TreeNode x) {
        if (x == null)
            return 0;

        int left = rec(x.left);
        int right = rec(x.right);
        max = Math.max(max, left + right);

        return Math.max(left, right) + 1;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
