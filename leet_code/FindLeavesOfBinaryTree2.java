package leet_code;

// https://leetcode.com/problems/find-leaves-of-binary-tree/description/
// 366. Find Leaves of Binary Tree

import java.util.*;

class FindLeavesOfBinaryTree2 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> findLeaves(TreeNode root) {
        if (root == null)
            return new ArrayList();
        
        List<List<Integer>> res = new ArrayList();
        rec(root, res);
        
        return res;
    }
    
    public int rec(TreeNode v, List<List<Integer>> res) {
        if (v == null)
            return -1;
        
        int height = 1 + Math.max(rec(v.left, res), rec(v.right, res));
        
        if (height == res.size())
            res.add(new ArrayList());
        
        res.get(height).add(v.val);
        
        return height;
    }
}
