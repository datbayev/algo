package leetcode;

// https://leetcode.com/problems/binary-tree-vertical-order-traversal/description/
// 314. Binary Tree Vertical Order Traversal

import java.util.*;

public class BinaryTreeVerticalOrderTraversal {
    class Item {
        int level;
        TreeNode node;

        Item(TreeNode node, int level) {
            this.level = level;
            this.node = node;
        }
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        Map<Integer, List<Integer>> map = new HashMap<>();
        int min = 0, max = 0;
        Queue<Item> q = new LinkedList<>();

        q.add(new Item(root, 0));

        while (!q.isEmpty()) {
            Item cur = q.poll();
            int level = cur.level;

            if (!map.containsKey(level))
                map.put(level, new ArrayList<>());

            map.get(level).add(cur.node.val);

            if (cur.node.left != null) {
                q.add(new Item(cur.node.left, level + 1));
                max = Math.max(max, level + 1);
            }

            if (cur.node.right != null) {
                q.add(new Item(cur.node.right, level - 1));
                min = Math.min(min, level - 1);
            }
        }

        List<List<Integer>> res = new ArrayList<>();

        for (int i = max; i >= min; i--)
            res.add(map.get(i));

        return res;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
