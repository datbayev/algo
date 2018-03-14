package leetcode;

// https://leetcode.com/problems/populating-next-right-pointers-in-each-node/description/
// 116. Populating Next Right Pointers in Each Node

import java.util.*;

public class PopulatingNextRightPointersInEachNode {
    public void connect(TreeLinkNode root) {
        List<TreeLinkNode> levels = new ArrayList<>();
        rec(root, levels, 0);
    }

    private void rec(TreeLinkNode node, List<TreeLinkNode> levels, int cur) {
        if (node == null)
            return;

        if (levels.size() == cur)
            levels.add(node);
        else {
            node.next = levels.get(cur);
            levels.set(cur, node);
        }

        rec(node.right, levels, cur + 1);
        rec(node.left, levels, cur + 1);
    }

    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
    }
}
