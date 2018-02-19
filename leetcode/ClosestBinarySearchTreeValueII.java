package leetcode;

// https://leetcode.com/problems/closest-binary-search-tree-value-ii/description/
// 272. Closest Binary Search Tree Value II

import java.util.*;

public class ClosestBinarySearchTreeValueII {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList();
        rec(root, res, k, target);
        return res;
    }

    private void rec(TreeNode node, List<Integer> res, int k, double target) {
        if (node == null)
            return;

        rec(node.left, res, k, target);
        if (res.size() < k)
            res.add(node.val);
        else {
            int first = res.get(0);
            if (Math.abs(first - target) > Math.abs(node.val - target)) {
                res.remove(0);
                res.add(node.val);
            }
        }

        rec(node.right, res, k, target);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
