package leetcode;

// https://leetcode.com/problems/find-largest-value-in-each-tree-row/description/
// 515. Find Largest Value in Each Tree Row

import java.util.*;

class FindLargestValueInEachTreeRow {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    List<Integer> res;
    
    public List<Integer> largestValues(TreeNode root) {
        res = new ArrayList();
        rec(root, 0);
        return res;
    }
    
    public void rec(TreeNode node, int level) {
        if (node == null)
            return;
        
        if (res.size() == level)
            res.add(node.val);
        else
            res.set(level, Math.max(node.val, res.get(level)));
        
        rec(node.left, level + 1);
        rec(node.right, level + 1);
    }
}
