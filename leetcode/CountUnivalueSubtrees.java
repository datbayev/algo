package leetcode;

// https://leetcode.com/problems/count-univalue-subtrees/description/
// 250. Count Univalue Subtrees

public class CountUnivalueSubtrees {
    int res = 0;

    public int countUnivalSubtrees(TreeNode root) {
        if (root == null)
            return 0;

        rec(root);
        return res;
    }

    private boolean rec(TreeNode node) {
        if (node == null)
            return true;

        boolean left = rec(node.left);
        boolean right = rec(node.right);

        if (left && right) {
            if (node.left != null && node.left.val != node.val)
                return false;

            if (node.right != null && node.right.val != node.val)
                return false;

            res++;
            return true;
        }

        return false;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
