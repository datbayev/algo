package leetcode;

import java.util.*;

public class ConvertBinarySearchTreeToSortedDoublyLinkedList {
    List<Node> list;
    public Node treeToDoublyList(Node root) {
        if (root == null)
            return null;

        list = new ArrayList<>();
        rec(root);

        for (int i = 0; i < list.size(); i++) {

            int next = (i + 1) % (list.size());
            int prev = i == 0 ? list.size() - 1 : i - 1;

            list.get(i).right = list.get(next);
            list.get(i).left = list.get(prev);
        }

        return list.get(0);
    }

    public void rec(Node node) {
        if (node == null)
            return;

        rec(node.left);
        list.add(node);
        rec(node.right);
    }

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };
}
