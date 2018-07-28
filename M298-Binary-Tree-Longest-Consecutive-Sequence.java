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
    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        return Math.max(helper(root.left, root.val, 1), helper(root.right, root.val, 1));
    }

    private int helper(TreeNode root, int prev, int len) {
        if (root == null) {
            return len;
        }
        if (root.val == prev + 1) {
            return Math.max(helper(root.left, root.val, len + 1), helper(root.right, root.val, len + 1));
        }
        else {
            return Math.max(len, Math.max(helper(root.left, root.val, 1), helper(root.right, root.val, 1)));
        }
    }
}
