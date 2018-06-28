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
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        return helper(root, 1);
    }

    private int helper(TreeNode root, int depth) {
        if (root.left == null && root.right == null) return depth;
        if (root.left == null) return helper(root.right, depth + 1);
        if (root.right == null) return helper(root.left, depth + 1);
        return Math.min(helper(root.left, depth + 1), helper(root.right, depth + 1));
    }
}
