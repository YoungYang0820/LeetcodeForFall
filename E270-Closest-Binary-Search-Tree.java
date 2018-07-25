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
    public int closestValue(TreeNode root, double target) {
        int res = root.val;
        TreeNode curr = root;
        while (curr != null) {
            if (Math.abs(curr.val - target) < Math.abs(res - target)) {
                res = curr.val;
            }
            if (curr.val < target) {
                curr = curr.right;
            } else if (curr.val > target) {
                curr = curr.left;
            } else {
                return curr.val;
            }
        }
        return res;
    }
}
