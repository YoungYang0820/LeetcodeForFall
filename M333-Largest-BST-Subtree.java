/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
        public int largestBSTSubtree(TreeNode root) {
            if(root == null) {
                return 0;
            }
            if(helper(root, Long.MIN_VALUE, Long.MAX_VALUE)) {
                return nodeCount(root);
            }
            int left = largestBSTSubtree(root.left);
            int right = largestBSTSubtree(root.right);
            return Math.max(left, right);
        }

        private int nodeCount(TreeNode root) {
            if(root == null) {
                return 0;
            }
            return nodeCount(root.left) + nodeCount(root.right) + 1;
        }

        private boolean helper(TreeNode root, long left, long right) {
            if(root == null) {
                return true;
            }
            if(root.val <= left || root.val >= right) {
                return false;
            }
            return helper(root.left, left, root.val) && helper(root.right, root.val, right);
        }
    }
