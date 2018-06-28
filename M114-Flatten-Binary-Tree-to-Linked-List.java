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
    public void flatten(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return;
        flatten(root.left);
        flatten(root.right);
        TreeNode tmp = root.right;
        TreeNode down = root.left;
        if (down == null) return;
        while(down.right != null) down = down.right;
        root.right = root.left;
        down.right = tmp;
        root.left = null;
    }
}
