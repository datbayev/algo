package leetcode;

// https://leetcode.com/problems/find-mode-in-binary-search-tree/description/
// 501. Find Mode in Binary Search Tree

import java.util.*;

public class FindModeInBinarySearchTree {
    TreeNode prev = null;
    int max = Integer.MIN_VALUE;
    List<Integer> res;
    int count = 0;

    public int[] findMode(TreeNode root) {
        if (root == null)
            return new int[0];

        res = new ArrayList<>();

        prev = root;
        rec(root);

        if (max < count) {
            res.clear();
            res.add(prev.val);
        } else if (max == count)
            res.add(prev.val);

        int[] ret = new int[res.size()];
        for (int i = 0; i < res.size(); i++)
            ret[i] = res.get(i);

        return ret;
    }

    private void rec(TreeNode node) {
        if (node == null)
            return;

        rec(node.left);

        if (prev.val == node.val) // same node, keep counting
            count++;
        else { // bumed into node with different value, compare
            if (max < count) { // hit new record, update max and add to res
                max = count;
                res.clear();
                res.add(prev.val);
            } else if (max == count) // same amount as some other number previously
                res.add(prev.val);

            count = 1;
            prev = node;
        }

        rec(node.right);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
