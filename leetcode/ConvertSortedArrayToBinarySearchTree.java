package leetcode;

// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
// 108. Convert Sorted Array to Binary Search Tree

public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return rec(nums, 0, nums.length - 1);
    }

    private TreeNode rec(int[] nums, int left, int right) {
        if (left == right)
            return new TreeNode(nums[left]);

        if (left > right)
            return null;

        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[mid]);

        node.left = rec(nums, left, mid - 1);
        node.right = rec(nums, mid + 1, right);

        return node;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
