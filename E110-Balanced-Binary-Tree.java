/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        return helper(root, 0) != -1;
    }

    private int helper(TreeNode root, int depth) {
        if (root == null) return depth;
        int left = helper(root.left, depth + 1);
        if (left == -1) return -1;
        int right = helper(root.right, depth + 1);
        if (right == -1) return -1;
        if (Math.abs(left - right) > 1) return -1;
        return Math.max(left, right);
    }
}
