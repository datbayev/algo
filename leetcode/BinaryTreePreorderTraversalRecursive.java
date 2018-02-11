package leetcode;

// https://leetcode.com/problems/binary-tree-preorder-traversal/description/
// 144. Binary Tree Preorder Traversal

import java.util.*;

public class BinaryTreePreorderTraversalRecursive {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        rec(root, res);
        return res;
    }

    private void rec(TreeNode node, List<Integer> list) {
        if (node == null)
            return;

        list.add(node.val);
        rec(node.left, list);
        rec(node.right, list);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
