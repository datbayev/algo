package leetcode;

// https://leetcode.com/problems/binary-tree-paths/description/
// 257. Binary Tree Paths

import java.util.*;

class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList();
        if (root == null)
            return res;

        rec(root, "" + root.val, res);

        return res;
    }

    public void rec(TreeNode x, String path, List<String> res) {
        if (x.left == null && x.right == null)
            res.add(path);

        if (x.left != null)
            rec(x.left, path + "->" + x.left.val, res);

        if (x.right != null)
            rec(x.right, path + "->" + x.right.val, res);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
