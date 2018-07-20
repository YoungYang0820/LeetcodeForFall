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
    private int count = 0;
    private int res = 0;
    public int kthSmallest(TreeNode root, int k) {
        search(root, k);
        return res;
    }

    private void search(TreeNode root, int k) {
        if (root == null) return;
        search(root.left, k);
        if (++count == k) {
            res = root.val;
            return;
        }
        search(root.right, k);
    }
}
