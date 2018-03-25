package leetcode;

// https://leetcode.com/problems/binary-search-tree-iterator/description/
// 173. Binary Search Tree Iterator

import java.util.*;

public class BSTIterator {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();

        if (root == null)
            return;

        stack.push(root);

        while (root.left != null) {
            stack.push(root.left);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode cur = stack.pop();
        int res = cur.val;
        if (cur.right != null) {
            stack.push(cur.right);
            cur = cur.right;
            while (cur.left != null) {
                stack.push(cur.left);
                cur = cur.left;
            }
        }

        return res;
    }
}

/*
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
 