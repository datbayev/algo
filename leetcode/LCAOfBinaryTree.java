package leetcode;

// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
// 236. Lowest Common Ancestor of a Binary Tree

import java.util.*;

class LCAOfBinaryTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    Map<TreeNode, TreeNode> parent;
    Map<TreeNode, Boolean> visited;
    boolean terminate;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null)
            return null;
        
        terminate = false;
        parent = new HashMap();
        visited = new HashMap();
        
        parent.put(root, null);
        
        traverse(root, p, q);
        
        return findCommonParent(root, p, q);
    }
    
    public TreeNode findCommonParent(TreeNode root, TreeNode p, TreeNode q) {
        while (p != root) {
            visited.put(p, true);
            p = parent.get(p);
        }
        
        while (q != root && !visited.containsKey(q))
            q = parent.get(q);
        
        return q;
    }
    
    public void traverse(TreeNode root, TreeNode p, TreeNode q) {
        if (parent.containsKey(p) && parent.containsKey(q)) {
            terminate = true;
            return;
        }
        
        if (root == null)
            return;
                
        if (!terminate && root.left != null) {
            parent.put(root.left, root);
            traverse(root.left, p, q);
        }
        
        if (!terminate && root.right != null) {
            parent.put(root.right, root);
            traverse(root.right, p, q);
        }
    }
}
