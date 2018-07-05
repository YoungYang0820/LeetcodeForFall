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
    int res = 0;
    public int sumNumbers(TreeNode root) {
        find(root, 0);
        return res;
    }

    private void find(TreeNode root, int prev) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            res += root.val + prev * 10;
        }
        find(root.left, root.val + prev * 10);
        find(root.right, root.val + prev * 10);

    }
}
