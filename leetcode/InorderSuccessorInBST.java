package leetcode;

// https://leetcode.com/problems/inorder-successor-in-bst/description/
// 285. Inorder Successor in BST

// the solution actually works for generic cases of any binary tree (not only BST)

public class InorderSuccessorInBST {
    TreeNode last = null;
    TreeNode res = null;
    boolean found = false;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null)
            return null;

        rec(root, p);

        return res;
    }

    private void rec(TreeNode node, TreeNode p) {
        if (node == null || found)
            return;

        rec(node.left, p);

        if (last != null && last.val == p.val && !found) {
            res = new TreeNode(node.val);
            found = true;
            return;
        }

        last = node;

        rec(node.right, p);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
