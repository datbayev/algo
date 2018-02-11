package leetcode;

// https://leetcode.com/problems/binary-tree-preorder-traversal/description/
// 144. Binary Tree Preorder Traversal

import java.util.*;

public class BinaryTreePreorderTraversalIterative {
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();

        st.add(root);
        while (!st.isEmpty()) {
            TreeNode cur = st.pop();
            res.add(cur.val);

            if (cur.right != null)
                st.add(cur.right);

            if (cur.left != null)
                st.add(cur.left);
        }

        return res;
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
