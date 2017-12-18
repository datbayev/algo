package leet_code;

// https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/description/
// 671. Second Minimum Node In a Binary Tree


class SecondMinimumNodeInABinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int min, init;
    
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null || root.left == null || root.right == null)
            return -1;
        
        min = -1;
        init = root.val;
        
        traverse(root);
        
        return min;
    }
    
    public void traverse(TreeNode v) {
        if (v == null)
            return;
        
        if (v.val > init && (min == -1 || min > v.val))
            min = v.val;
        
        traverse(v.left);
        traverse(v.right);
    }
}
