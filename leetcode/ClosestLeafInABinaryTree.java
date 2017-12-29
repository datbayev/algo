package leetcode;

// https://leetcode.com/problems/closest-leaf-in-a-binary-tree/description/
// 743. Closest Leaf in a Binary Tree

import java.util.*;

public class ClosestLeafInABinaryTree {
    private int[][] g;
    private boolean[] isLeaf;

    public int findClosestLeaf(TreeNode root, int k) {
        int res = k;
        g = new int[1001][1001];
        boolean[] used = new boolean[1001];
        isLeaf = new boolean[1001];

        buildGraph(root);

        LinkedList<Integer> q = new LinkedList<>();
        q.add(k);

        while (!q.isEmpty()) {
            int cur = q.poll();
            used[cur] = true;

            if (isLeaf[cur]) {
                res = cur;
                break;
            }

            for (int i = 1; i < 1001; i++) {
                if (g[i][cur] > 0 && !used[i])
                    q.add(i);
            }
        }

        return res;
    }

    private void buildGraph(TreeNode root) {
        if (root.left != null) {
            g[root.val][root.left.val] = 1;
            g[root.left.val][root.val] = 1;

            buildGraph(root.left);
        }

        if (root.right != null) {
            g[root.val][root.right.val] = 1;
            g[root.right.val][root.val] = 1;

            buildGraph(root.right);
        }

        if (root.left == null && root.right == null)
            isLeaf[root.val] = true;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
