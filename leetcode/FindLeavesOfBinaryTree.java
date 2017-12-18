package leetcode;

// https://leetcode.com/problems/find-leaves-of-binary-tree/description/
// 366. Find Leaves of Binary Tree

import java.util.*;

class FindLeavesOfBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    Map<Integer, List<Integer>> map;
    int counter = 1, maxCounter = 1;
    boolean up;
    
    public List<List<Integer>> findLeaves(TreeNode root) {
        if (root == null)
            return new ArrayList();
        
        map = new HashMap();
        List<List<Integer>> res = new ArrayList();
        
        rec(root);
        
        for (int i = 1; i <= maxCounter; i++)
            if (map.containsKey(i))
                res.add(map.get(i));
        
        return res;
    }
    
    public void rec(TreeNode v) {
        int level = -1;
        
        if (v.left != null) {
            up = false;
            rec(v.left);
            if (up)
                counter++;
            level = Math.max(level, counter);
            counter = level;
            maxCounter = Math.max(maxCounter, level);
        }
        
        if (v.right != null) {
            up = false;
            rec(v.right);
            if (up)
                counter++;
            level = Math.max(level, counter);
            counter = level;
            maxCounter = Math.max(maxCounter, level);
        }
        
        if (v.left == null && v.right == null) {
            addToMap(v, 1);
            counter = 1;
            up = true;
        } else {
            addToMap(v, level);
        }
    }
    
    public void addToMap(TreeNode node, int num) {
        if (!map.containsKey(num))
            map.put(num, new ArrayList());
        
        map.get(num).add(node.val);
    }
}
