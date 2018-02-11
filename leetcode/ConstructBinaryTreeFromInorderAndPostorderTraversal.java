package leetcode;

// https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
// 106. Construct Binary Tree from Inorder and Postorder Traversal

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return rec(inorder.length - 1, 0, inorder.length - 1, inorder, postorder);
    }

    private TreeNode rec(int index, int start, int end, int[] in, int[] post) {
        if (start > end || index > post.length - 1)
            return null;

        TreeNode root = new TreeNode(post[index]);

        if (start == end)
            return root;

        int i;
        for (i = start; i <= end; i++)
            if (in[i] == root.val)
                break;

        root.right = rec(index - 1, i + 1, end, in, post);
        root.left = rec(index - end + i - 1, start, i - 1, in, post);

        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
