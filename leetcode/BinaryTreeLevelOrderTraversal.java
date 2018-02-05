package leetcode;

// https://leetcode.com/problems/binary-tree-level-order-traversal/description/
// 102. Binary Tree Level Order Traversal

import java.util.*;

class BinaryTreeLevelOrderTraversal {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        traverse(root, 0, result);
        
        return result;
    }
    
    private void traverse(TreeNode node, int level, List<List<Integer>> res) {
        if (node == null)
            return;

        if (res.size() == level)
            res.add(new ArrayList<>());

        res.get(level).add(node.val);
        
        traverse(node.left, level + 1, res);
        traverse(node.right, level + 1, res);
    }
}
