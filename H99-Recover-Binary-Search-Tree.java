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
    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {
        find(root);
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }

    private void find(TreeNode root) {
        if (root == null) return;
        find(root.left);
        if (first == null && root.val <= prev.val) {
            first = prev;
        }
        if (first != null && root.val <= prev.val) {
            second = root;
        }
        prev = root;
        find(root.right);
    }
}
