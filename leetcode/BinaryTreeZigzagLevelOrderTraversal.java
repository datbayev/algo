package leetcode;

// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
// 103. Binary Tree Zigzag Level Order Traversal

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        rec(root, 0, res);
        return res;
    }

    private void rec(TreeNode node, int level, List<List<Integer>> res) {
        if (node == null)
            return;

        if (level == res.size())
            res.add(new ArrayList<>());

        if (level % 2 == 0)
            res.get(level).add(node.val);
        else
            res.get(level).add(0, node.val);

        rec(node.left, level + 1, res);
        rec(node.right, level + 1, res);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
