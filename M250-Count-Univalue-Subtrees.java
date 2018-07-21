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
    private int res = 0;
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) return 0;
        helper(root);
        return res;
    }

    private boolean helper(TreeNode root) {
        if (root == null) return false;
        boolean l = helper(root.left);
        boolean r = helper(root.right);
        if (isSame(root, root.left, l) && isSame(root, root.right, r)) {
            res++;
            return true;
        }
        return false;
    }

    private boolean isSame(TreeNode root, TreeNode child, boolean s) {
        return child == null || s && root.val == child.val;
    }
}
