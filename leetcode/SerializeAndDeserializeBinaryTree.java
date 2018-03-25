package leetcode;

import java.util.*;

// https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
// 297. Serialize and Deserialize Binary Tree

public class SerializeAndDeserializeBinaryTree {
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder res = new StringBuilder();
            Queue<TreeNode> q = new LinkedList(); // simple queue implementation
            q.add(root);

            while (!q.isEmpty()) {
                TreeNode cur = q.poll();
                res.append((cur == null ? "null" : cur.val) + ",");

                if (cur == null)
                    continue;

                q.add(cur.left);
                q.add(cur.right);
            }

            res.deleteCharAt(res.length() - 1);
            return res.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            int left = 0, right = 1;
            String[] nodes = data.split(",");
            TreeNode[] list = new TreeNode[nodes.length];

            while (left < nodes.length) {
                while (left < nodes.length && nodes[left].equals("null"))
                    left++;

                if (left == nodes.length)
                    break;

                if (list[left] == null)
                    list[left] = new TreeNode(Integer.parseInt(nodes[left]));

                if (!nodes[right].equals("null")) {
                    list[right] = new TreeNode(Integer.parseInt(nodes[right]));
                    list[left].left = list[right];
                }

                if (!nodes[right + 1].equals("null")) {
                    list[right + 1] = new TreeNode(Integer.parseInt(nodes[right + 1]));
                    list[left].right = list[right + 1];
                }

                right += 2;
                left++;
            }

            return list[0];
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
