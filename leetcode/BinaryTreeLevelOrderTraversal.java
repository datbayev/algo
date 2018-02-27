package leetcode;

// https://leetcode.com/problems/binary-tree-level-order-traversal/description/
// 102. Binary Tree Level Order Traversal

import java.util.*;

class BinaryTreeLevelOrderTraversal {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        traverse(root, 0, result);
        
        return result;
    }
    
    private void traverse(TreeNode node, int level, List<List<Integer>> res) {
        if (node == null)
            return;

        if (res.size() == level)
            res.add(new ArrayList<>());

        res.get(level).add(node.val);
        
        traverse(node.left, level + 1, res);
        traverse(node.right, level + 1, res);
    }

    public List<List<Integer>> levelOrderQueues(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        q.add(null);

        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());

        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (cur == null) {
                if (q.isEmpty())
                    break;

                res.add(new ArrayList<>());
                q.add(null);
                continue;
            }

            res.get(res.size() - 1).add(cur.val);

            if (cur.left != null)
                q.add(cur.left);

            if (cur.right != null)
                q.add(cur.right);
        }

        return res;
    }
}
