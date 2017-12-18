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

    Map<Integer, List<Integer>> map;
    int maxLevel = 0;
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        
        map = new HashMap();
        traverse(root, 0);
        
        if (root == null)
            return result;
        
        for (int i = 0; i <= maxLevel; i++)
            result.add(map.get(i));
        
        return result;
    }
    
    public void traverse(TreeNode node, int level) {
        if (node == null)
            return;
        
        if (!map.containsKey(level))
            map.put(level, new ArrayList());
        
        map.get(level).add(node.val);
        
        maxLevel = Math.max(maxLevel, level);
        
        traverse(node.left, level + 1);
        traverse(node.right, level + 1);
    }
}
