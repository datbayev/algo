package leetcode;

// https://leetcode.com/problems/binary-tree-right-side-view/description/
// 199. Binary Tree Right Side View

import java.util.*;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        List<Integer> res = new ArrayList<>();
        rec(root, 0, res);
        return res;
    }

    private void rec(TreeNode node, int depth, List<Integer> list) {
        if (node == null)
            return;

        if (depth == list.size())
            list.add(node.val);

        rec(node.right, depth + 1, list);
        rec(node.left, depth + 1, list);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
