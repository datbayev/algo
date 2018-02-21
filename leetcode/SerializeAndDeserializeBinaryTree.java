package leetcode;

import java.util.*;

// https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
// 297. Serialize and Deserialize Binary Tree

public class SerializeAndDeserializeBinaryTree {
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null)
                return "";

            StringBuilder res = new StringBuilder();
            ArrayDeque<TreeNode> q = new ArrayDeque<>();
            q.add(root);
            res.append(root.val).append(";");

            while (!q.isEmpty()) {
                TreeNode cur = q.pollFirst();
                res.append(String.format("%s;%s;", (cur.left != null ? cur.left.val : "null"), (cur.right != null ? cur.right.val : "null")));

                if (cur.left != null)
                    q.add(cur.left);

                if (cur.right != null)
                    q.add(cur.right);
            }

            res.deleteCharAt(res.length() - 1);
            return res.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.equals(""))
                return null;

            String[] nodes = data.split(";");
            int child = 0;

            TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
            ArrayDeque<TreeNode> q = new ArrayDeque<>();
            q.add(root);

            while (!q.isEmpty()) {
                TreeNode node = q.pollFirst();

                child++;
                if (child < nodes.length && !nodes[child].equals("null")) {
                    TreeNode left = new TreeNode(Integer.parseInt(nodes[child]));
                    node.left = left;
                    q.add(left);
                }

                child++;
                if (child < nodes.length && !nodes[child].equals("null")) {
                    TreeNode right = new TreeNode(Integer.parseInt(nodes[child]));
                    node.right = right;
                    q.add(right);
                }
            }

            return root;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
