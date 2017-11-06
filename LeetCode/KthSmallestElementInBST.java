// https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
// 230. Kth Smallest Element in a BST

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class KthSmallestElementInBST {
    int answer, count, k;
    boolean found;
    
    public int kthSmallest(TreeNode root, int k) {
        found = false;
        answer = root.val;
        count = 0;
        this.k = k;
        
        rec(root);
        
        return answer;
    }
    
    public void rec(TreeNode v) {
        if (v == null || found)
            return;
        
        rec(v.left);
        count++;
        
        if (count == k) {
            answer = v.val;
            found = true;
            return;
        }
        
        rec(v.right);
    }
}
