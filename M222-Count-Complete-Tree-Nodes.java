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
    public int countNodes(TreeNode root) {
        int leftH = height(root) - 1;
        TreeNode curr = root;
        int res = 0;
        while (curr != null) {
            int rightH = height(curr.right);
            if (leftH == rightH) {
                res += (1 << leftH);
                curr = curr.right;
            }
            else {
                res += (1 << rightH);
                curr = curr.left;
            }
            leftH--;
        }
        return res;
    }

    private int height(TreeNode root) {
        int count = 0;
        while (root != null) {
            count++;
            root = root.left;
        }
        return count;
    }
}
