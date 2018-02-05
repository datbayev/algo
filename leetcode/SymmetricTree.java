package leetcode;

// https://leetcode.com/problems/symmetric-tree/description/
// 101. Symmetric Tree


class SymmetricTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSymmetric(TreeNode root) {
        return root == null || rec(root.left, root.right);
    }
    
    public boolean rec(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;

        return left != null && right != null && left.val == right.val &&
                rec(left.left, right.right) && rec(left.right, right.left);
    }
}
