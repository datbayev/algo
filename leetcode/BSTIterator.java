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

    int ind;
    List<Integer> storage;

    public BSTIterator(TreeNode root) {
        storage = new ArrayList();
        ind = 0;
        initIterator(root);
    }
    
    public void initIterator(TreeNode root) {
        if (root == null)
            return;
        
        if (root.left != null)
            initIterator(root.left);
        
        storage.add(root.val);
        
        if (root.right != null)
            initIterator(root.right);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return ind < storage.size();
    }

    /** @return the next smallest number */
    public int next() {
        return storage.get(ind++);
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
 