package leetcode;

// https://leetcode.com/problems/binary-search-tree-iterator/discuss/
// 173. Binary Search Tree Iterator

import java.util.*;


public class BSTIteratorStack {
    Stack<TreeNode> stack;

    public BSTIteratorStack(TreeNode root) {
        stack = new Stack();
        
        TreeNode cur = root;
        while (cur != null) {
            stack.push(cur);
            if (cur.left != null)
                cur = cur.left;
            else
                break;
        }
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        TreeNode cur = node;
        
        if (cur.right != null) {
            cur = cur.right;
            
            while (cur != null) {
                stack.push(cur);
                if (cur.left != null)
                    cur = cur.left;
                else
                    break;
            }
        }
        
        return node.val;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
