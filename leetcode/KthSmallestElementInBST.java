package leetcode;

// https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
// 230. Kth Smallest Element in a BST

class KthSmallestElementInBST {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int count = 0;
    int res;
    boolean found = false;

    public int kthSmallest(TreeNode root, int k) {
        res = root.val;
        rec(root, k);
        return res;
    }

    private void rec(TreeNode node, int k) {
        if (node == null)
            return;

        rec(node.left, k);

        if (found)
            return;

        if (++count == k) {
            res = node.val;
            found = true;
            return;
        }

        rec(node.right, k);
    }
}
