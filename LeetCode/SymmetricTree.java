// https://leetcode.com/problems/symmetric-tree/description/
// 101. Symmetric Tree

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        
        return rec(root.left, root.right);
    }
    
    public boolean rec(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        
        if ((left == null && right != null) || (left != null && right == null))
            return false;
        
        if (left.val != right.val)
            return false;
        
        return rec(left.left, right.right) && rec(left.right, right.left);
    }
}
