package leetcode;

// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
// 105. Construct Binary Tree from Preorder and Inorder Traversal

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0)
            return null;

        return rec(preorder, inorder, 0, 0, preorder.length - 1);
    }

    private TreeNode rec(int[] pre, int[] in, int index, int left, int right) {
        if (index > pre.length - 1 || left > right)
            return null;

        TreeNode root = new TreeNode(pre[index]);

        if (left == right) // no more possible to dig in
            return root;

        int i;
        for (i = left; i <= right; i++)
            if (in[i] == root.val)
                break;

        root.left = rec(pre, in, index + 1, left, i - 1);
        root.right = rec(pre, in, index + i - left + 1, i + 1, right);

        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
